pipeline {

    environment {
    registry = "feresmch/timesheet"
    registryCredential = 'dockerHub'
    dockerImage = ''
    }
    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git";
                git branch: "Feres_Mechmech",
                    url: "https://github.com/mohamed-kbaier/Timesheet",
                    credentialsId: "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";
            }
        }


        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package -DskipTests"
                // sh "mvn clean package -DskipTests" pour une machine linux
            }
        }

        stage("Unit Tests"){
            steps{
                bat "mvn test"
            }
        }

        stage("Static test : Sonar") {
            steps {
                bat "mvn sonar:sonar -Dsonar.projectKey=Timesheet -Dsonar.host.url=http://localhost:9000 -Dsonar.login=271e61392f44e37461e9d26eb7cf888677019725"
            }
        }

        stage("Clean and Packaging"){
            steps{
                bat "mvn clean package"
            }
        }

        stage("DEPLOY : Nexus") {
            steps {
                bat "mvn clean package deploy:deploy-file -DgroupId=tn.spring -DartifactId=timesheet -Dversion=0.0.1 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-0.0.1.war"
            }
        }
         stage('Building our image : DOCKER') {
                    steps{
                         script {
                            dockerImage = docker.build registry + ":$BUILD_NUMBER"
                         }
                    }
               }
         stage('Deploy our image : DOCKER') {
            steps {
                script {
                             docker.withRegistry( '', registryCredential ) {
                             dockerImage.push()
                              }
                          }
                    }
               }
         stage('Cleaning up : DOCKER') {
            steps {
                  bat "docker rmi $registry:$BUILD_NUMBER"
                            }
                    }

        stage('Runnig Application : DOCKER') {
                     steps {
                            bat "docker-compose up"
                            }
                     }
          stage('Pulling MySQL') {
               steps {
                     bat "docker pull mysql"
                            }
                     }
          stage('Pulling Project') {
               steps {
                    bat "docker pull feresmch/timesheet:55"
                            }
                     }
     }

    post {
        always {
             emailext body: 'Your Build has run successfully !!!', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Devops Timesheet-Jenkins'
            cleanWs()
        }
    }

}