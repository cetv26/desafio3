pipeline {
    environment {
        registry = "ctisz/desafio3"
        registryCredential = 'dockerhub'

      }
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage('Compile stage') {
            steps {
                sh "mvn clean compile"
            }
        }
        stage('package') {
            steps {
                sh "mvn package"
            }
        }

        stage('Building image') {
            steps{
                script {
                    dockerImage = docker.build registry
                }
            }
        }

        stage('Deploy Image') {
             steps{
                script {
                  docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                  }
                }
            }
        }
         stage('Remove Unused docker image') {
              steps{
                sh "docker rmi $registry"
              }
            }





                stage('Deploy ec2') {
                    steps{


                            sh """
                            chmod 400 /var/jenkins_home/intercorp.pem
                            ls /var/jenkins_home/
                            ssh -i /var/jenkins_home/intercorp.pem -o StrictHostKeyChecking=no ubuntu@ec2-18-234-103-69.compute-1.amazonaws.com bash -c \\"sudo docker rm \$(docker stop \$(docker ps -a -q  --filter ancestor=$registry)) \\"
                            ssh -i /var/jenkins_home/intercorp.pem -o StrictHostKeyChecking=no ubuntu@ec2-18-234-103-69.compute-1.amazonaws.com bash -c \\"sudo   docker run -d -t -p 8050:8080 $registry\\"

                            """


                    }

                }
    }
}
