pipeline {
    agent any

    stages {
        stage('Git') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/lavanya135246/jgsu-spring-petclinic.git'
            }
        }
        stage('Build Project') {
            steps {
                
                
                sh './mvnw clean package'

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            //post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                //success {
                //    junit '**/target/surefire-reports/TEST-*.xml'
                //    archiveArtifacts 'target/*.jar'
                //}
            //}
        }
    }
}
