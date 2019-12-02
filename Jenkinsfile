pipeline {
    environment {
        registry = "docker_hub_account/repository_name"
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
        stage('Deploy') {
            withCredentials([sshUserPrivateKey(credentialsId: 'aws', keyFileVariable: 'aws', passphraseVariable: '', usernameVariable: '')]) {
                         steps{
                             sh "ssh -i ${aws} ec2-54-152-115-203.compute-1.amazonaws.com"
                         }       // some block
            }

        }

    }

}
