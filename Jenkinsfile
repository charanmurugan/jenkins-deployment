pipeline {
    agent any

    tools {
        maven 'maven'   // Ensure this matches your Jenkins tool configuration
        jdk 'java-17'         // Use appropriate JDK version
    }

    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/charanmurugan/jenkins-deployment.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Verify Coverage Threshold') {
            steps {
                script {
                    def coverageReport = readFile 'target/site/jacoco/jacoco.xml'
                    def matcher = coverageReport =~ /<counter type="INSTRUCTION" missed="(\d+)" covered="(\d+)"\/>/
                    if (matcher.find()) {
                        def missed = matcher.group(1).toInteger()
                        def covered = matcher.group(2).toInteger()
                        def total = missed + covered
                        def coveragePercent = (covered / total) * 100

                        echo "Instruction coverage: ${coveragePercent}%"
                        if (coveragePercent < 80) {
                            error "Code coverage ${coveragePercent}% is below threshold (80%)"
                        }
                    } else {
                        error "Could not find coverage data in jacoco.xml"
                    }
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }

        success {
            echo 'Build and tests passed.'
        }

        failure {
            echo 'Build or tests failed.'
        }
    }
}
