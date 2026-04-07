pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Report') {
            steps {
              publishHTML([
    reportDir: 'reports',
    reportFiles: 'index.html',
    reportName: 'Extent Report',
    keepAll: true,
    alwaysLinkToLastBuild: true,
    allowMissing: true
])
            }
        }
    }
}
