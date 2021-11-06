pipeline {

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
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar -Dsonar.projectKey=Timesheet -Dsonar.host.url=http://localhost:9000 -Dsonar.login=271e61392f44e37461e9d26eb7cf888677019725"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn clean package deploy:deploy-file -DgroupId=tn.spring -DartifactId=timesheet -Dversion=0.0.1 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-0.0.1.war"
            }
        }
         stage("Email Notification"){
             steps {
             emailext(attachLog: true, body: '''Hi, 

Your build has been successful !! 

Best,
Feres''', subject: 'Devops Project', to: 'mohamedfares.mechmech@gmail.com')
             }
      
         }}
   
    post {
        always {
            cleanWs()
        }
    }
    
}
