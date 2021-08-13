pipeline {
    agent any
    
 stages {
     
     stage('Maven-Version-Check') {
            steps {
                sh 'mvn -version'
            }
        }
     
      stage('checkout') {
          steps {
              
               git credentialsId: 'Git', url: 'https://github.com/gitvivekraj/firstmaven.git'
          }
        }
  stage('Execute Maven') {
           steps {
             
                sh 'mvn clean install -f Calculator/pom.xml'             
          }
        }
   stage('Docker Build and Tag') {
           steps {
              
                sh 'docker build -t firstdockerhubrepo:latest .' 
                sh 'docker tag firstdockerhubrepo dockervivek3010/firstdockerhubrepo:latest'    
          }
        }
     
  stage('Publish image to Docker Hub') {
          
            steps {
        withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
          sh  'docker push dockervivek3010/firstdockerhubrepo:latest' 
        }
                  
          }
        }
     
      stage('Run Docker container on Jenkins Agent') {
             
            steps 
   {
                sh "docker run -d --name calculator -p 8003:8080 dockervivek3010/firstdockerhubrepo"
 
            }
        }
 }
