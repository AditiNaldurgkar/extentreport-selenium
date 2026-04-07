pipeline {
    agent any

    tools {
        jdk 'jdk21'   // 👈 THIS IS MISSING
    }

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
                publishHTML(target: [
                    reportDir: 'target',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Test Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }
    }
}