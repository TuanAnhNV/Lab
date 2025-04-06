pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'lab-springboot-app:latest'
    }

    stages {
        stage('Build Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Run Docker Container') {
            steps {
                // Stop và remove container cũ nếu có
                sh '''
                    docker stop lab-app || true
                    docker rm lab-app || true
                    docker run -d --name lab-app -p 9001:9001 $DOCKER_IMAGE
                '''
            }
        }
    }

    post {
        success {
            echo 'App deployed successfully using Docker!'
        }
        failure {
            echo 'Something went wrong!'
        }
    }
}