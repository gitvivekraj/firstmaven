pipeline {
    agent any
    
 stages {
     
     stage('Maven-Version-Check') {
            steps {
                sh 'mvn -version'
            }
        }
     
      stage('git-clone') {
          steps {
              
               git credentialsId: 'Git', url: 'https://github.com/gitvivekraj/firstmaven.git'
          }
        }
  stage('Maven-Build') {
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
     
  stage('Publish image to DockerHub') {
          
            steps {
        withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
          sh  'docker push dockervivek3010/firstdockerhubrepo:latest' 
        }
                  
          }
        }
     
      stage('Run Docker container on Jenkins Agent') {
             
            steps 
   {
                sh "docker run -d --name calculator -p 8010:8080 dockervivek3010/firstdockerhubrepo"
 
            }
        }
 }
