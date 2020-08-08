# Sample REST API with Spring Boot

## How to Build
```
mvn package
```

## How to Run
```
mvn spring-boot:run
```

## How to Test
```
http://localhost:8080/demo/sum?a=2&b=54
```

## Running docker image
```
docker run -d --name demo -p 8080:8080 marcelormourao/uni7-cloud-native:1.0.0
```

## Docker image
Docker image are available at [DockerHub](https://hub.docker.com/r/marcelormourao/uni7-cloud-native).
