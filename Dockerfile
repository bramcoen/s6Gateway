FROM openjdk:18-jdk-alpine
WORKDIR /usr/app
COPY target/s6-0.0.1-SNAPSHOT.jar s6-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","s6-0.0.1-SNAPSHOT.jar"]
EXPOSE 8100
