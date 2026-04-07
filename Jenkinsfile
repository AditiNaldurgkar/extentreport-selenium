pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/AditiNaldurgkar/extentreport-selenium.git'
            }
        }

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
