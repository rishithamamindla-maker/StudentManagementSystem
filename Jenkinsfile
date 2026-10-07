pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:\\Users\\rishi\\Downloads\\apache-maven-3.9.16-bin\\apache-maven-3.9.16'
        PATH = "${MAVEN_HOME}\\bin;${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
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

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t student-management:latest .'
            }
        }

        stage('Docker Run') {
            steps {
                bat 'docker rm -f student-management-container || exit 0'
                bat 'docker run --name student-management-container --network student-network student-management:latest'
            }
        }
    }
}