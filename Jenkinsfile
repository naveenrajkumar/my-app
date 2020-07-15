node {
    stage 'Clone the project'
    git 'https://github.com/naveenrajkumar/my-app.git'

    stage("findbugs"){
        sh "./gradlew findbugsmain"
    }
    stage("checkstyle"){
        sh "./gradlew checkstylemain"
    }
    stage("test"){
        sh "./gradlew test"
    }  
    stage(" build"){
            app =  docker.build("my-app")
    }
    stage(" deploy"){
        sh "docker stop my-app || exit 0"
        sh "docker rm my-app || exit 0"
        sh "docker container run --name my-app -d -p 8081:8080 my-app"
    }   
   
}       
