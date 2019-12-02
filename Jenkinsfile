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
                    docker.build registry + ":$BUILD_NUMBER"
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


    }

}
