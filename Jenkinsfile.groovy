pipeline {
    agent any

    stages {
        stage('Clean Workspace') {
            steps {
                script {
                    echo 'Cleaning workspace...'
                    bat 'if exist Jenkins-pipeline rd /s /q Jenkins-pipeline'
                }
            }
        }

        stage('Clone Repository') {
            steps {
                script {
                    echo 'Cloning repository...'
                    bat 'git clone "https://github.com/AlishkaFernandes19/2313_ISA2.git"'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo 'Building Docker image...'
                    bat 'docker build -t 2313ISA:latest .'
                }
            }
        }


        stage('delete the container') {
            steps {
                script {
                    echo 'deleting the container...'
                    bat 'docker rm -f 2313'
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    echo 'Running Docker container...'
                    bat 'docker run -d --name 2313 -p 5000:5000 2313ISA:latest'
                }
            }
        }
    }
}
