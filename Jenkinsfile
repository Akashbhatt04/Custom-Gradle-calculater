pipeline {
    agent any
    environment {
        SONARQUBE_ENV = 'LocalSonar'
        SONAR_SCANNER = 'SonarScanner'
    }

    triggers {
        cron('H 10 * * *') // Run daily at 10 AM
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Akashbhatt04/Custom-Gradle-calculater.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARQUBE_ENV}") {
                    sh "${tool SONAR_SCANNER}/bin/sonar-scanner"
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }

        stage('Cleanup') {
            steps {
                cleanWs()
            }
        }
    }
}
