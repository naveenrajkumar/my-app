# My App 
A sample web app in java which gives git version

## Docker Setup and Run
```sh
$ docker image build -t my-app .
$ docker container run -d -p 808:8080 my-app
$ curl http://localhost:8080/version
{"myapplicaiton":{"lastcommitsha":"3aba5d184e1c550f3e0c8bdc08a19657eff56cba1.0.0","description":"pre-interview technical test","version":"1.0.0"}}
```

### Deployments on AWS - 
```sh
Jenkins - http://3.106.119.168:8080/job/my-app/
userid/pass - myappuser/myappuser
App - http://3.106.119.168:8081/version
```

![alt text](https://github.com/naveenrajkumar/my-app/blob/master/pipeline.png)
