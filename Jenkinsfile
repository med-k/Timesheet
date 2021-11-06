pipeline {

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
        stage("clean and packaging"){
            steps{
                bat "mvn clean package"
            }
        }
        stage("DEPLOY") {
            steps {
                bat "mvn clean package deploy:deploy-file -DgroupId=tn.spring -DartifactId=timesheet -Dversion=0.0.1 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-0.0.1.war"
            }
        }
         stage("email not") {
                    steps {
                          emailext body: 'work done', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Tiùesheet'
                    }
    }
}
}
