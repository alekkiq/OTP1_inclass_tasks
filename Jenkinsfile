
pipeline {
  agent any

  tools {
      maven 'Maven3.9'
  }

    environment {
          PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
          DOCKERHUB_CREDENTIALS_ID = '123'
          DOCKERHUB_REPO = 'alekkiq/OTP1_inclass_tasks'
          DOCKER_IMAGE_TAG = 'v1'
      }

  stages {

      stage('Checkout') {
          steps {
              git 'https://github.com/alekkiq/OTP1_inclass_tasks.git'
          }
      }

      stage('Run Tests') {
          steps {
              bat 'mvn clean test'
          }
      }

      stage('Code Coverage') {
          steps {
              bat 'mvn jacoco:report'
          }
      }

      stage('Publish Test Results') {
          steps {
              junit '**/target/surefire-reports/*.xml'
          }
      }

      stage('Publish Coverage Report') {
          steps {
              jacoco()
          }
      }

      stage('Build Docker Image') {
          steps {
              script {
                  docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
              }
          }
      }

      stage('Push Docker Image to Docker Hub') {
          steps {
              script {
                  docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                      docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                  }
              }
          }
      }

  }
}
