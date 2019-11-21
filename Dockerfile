FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar reactive-cinema.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo:27017/cinema_test","-jar","/reactive-cinema.jar"]
