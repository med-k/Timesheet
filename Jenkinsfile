pipeline {
    environment {
    registry = "medk123456/timesheet"
    registryCredential = 'dockerHub'
    dockerImage = ''
    }
    agent any


    stages {
       stage ('Cloning Project from Git') {
            steps {
               echo "Getting Project from Git";
                               git branch: "mohamedkbaier",
                                   url: "https://github.com/mohamed-kbaier/Timesheet",
                                   credentialsId: "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";
            }
        }
        stage("Build") {
            steps {
                bat "mvn compile"
            }
        }
        stage("Unit Tests"){
            steps{
                bat "mvn test"
            }
        }
        stage("Static Test") {
            steps {
                bat "mvn sonar:sonar -Dsonar.projectKey=Timesheet -Dsonar.host.url=http://localhost:9000 -Dsonar.login=8bb50f6c9be0c520735c2e07cdecfb8f7e92a3b5"
            }
        }
        stage("Clean and Packaging"){
            steps{
                bat "mvn clean package"
            }
        }
        stage("DEPLOY") {
            steps {
                bat "mvn clean package deploy:deploy-file -DgroupId=tn.spring -DartifactId=timesheet -Dversion=0.0.1 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-0.0.1.war"
            }
        }
        stage('Building our image') {
            steps{
                    script {
                       dockerImage = docker.build registry + ":$BUILD_NUMBER"
                    }
                  }
        }
        stage('Deploy our image') {
            steps {
                    script {
                            docker.withRegistry( '', registryCredential ) {
                            dockerImage.push()
                         }
                        }
                    }
                }
        stage('Cleaning up') {
               steps {
                        bat "docker rmi $registry:$BUILD_NUMBER"
                     }
                }
}
        post{
            always{
                emailext body: 'work done', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Tiùesheet'
                cleanWs()
                }
        }
}
