pipeline {
    agent any

      stages {
            stage('Build') {
                steps {
                    sh 'mvn clean install'
                }
            }

            stage('Deploy') {
                steps {
                    sh 'java -jar target/Lab-0.0.1-SNAPSHOT.jar'
                }
            }
      }

      post {
            success {
                echo "Deployment successful!"
            }
            failure {
                echo "Deployment failed."
            }
      }
}