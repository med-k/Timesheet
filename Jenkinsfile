pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "alabachhamba", 
                    url: "https://github.com/mohamed-kbaier/Timesheet",
                    credentialsId: "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"; 
            }
        }

 
        stage("Build") {
            steps {
                
                bat "mvn clean package -DskipTests"
                
            }
        }
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar -Dsonar.projectKey=Department -Dsonar.host.url=http://localhost:9000 -Dsonar.login=70ec87936f498b7a0ca0f34b03cbbc991ce9dcac"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn clean package deploy:deploy-file -DgroupId=tn.spring -DartifactId=timesheet -Dversion=0.0.1 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-0.0.1.war"
            }
        }
         
             stage("email") {
            steps {
                  emailext body: 'work', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Tiùesheet'
            }
        }
      
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
