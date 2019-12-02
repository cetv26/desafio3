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

                        sshagent(['aws']) {
                            sh 'ping 172.31.56.30'
                            sh 'ssh -tt 172.31.56.30 "sudo docker run -t -p 8050:8080 $registry"'
                        }
                    }

                }
    }
}
