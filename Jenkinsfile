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
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
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
                sh "docker rmi $registry:$BUILD_NUMBER"
              }
            }





                stage('Deploy ec2') {
                    steps{
                        withCredentials([sshUserPrivateKey(credentialsId: 'aws', keyFileVariable: 'aws', passphraseVariable: '', usernameVariable: '')]) {


                            sh "ssh -i ${aws} -T ubuntu@ec2-54-152-115-203.compute-1.amazonaws.com 'docker run -it -p 8050:8080 $registry:$BUILD_NUMBER'"
                        }
                    }

                }
    }
}
