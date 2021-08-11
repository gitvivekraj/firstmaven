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
                //sh 'docker tag samplewebapp nikhilnidhi/samplewebapp:$BUILD_NUMBER'
               
          }
        }
     
  stage('Publish image to Docker Hub') {
          
            steps {
        withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
          sh  'docker push dockervivek3010/firstdockerhubrepo:latest'
        //  sh  'docker push nikhilnidhi/samplewebapp:$BUILD_NUMBER' 
        }
                  
          }
        }
     
      stage('Run Docker container on Jenkins Agent') {
             
            steps 
   {
                sh "docker run -d -p 8003:8080 dockervivek3010/firstdockerhubrepo"
 
            }
        }
//   stage('Run Docker container on remote hosts') {
//               steps {
//                  sh "docker -H ssh://jenkins@172.31.28.25 run -d -p 8003:8080 dockervivek3010/firstdockerhubrepo"
//              }
//          }
    }
 }
