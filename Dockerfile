FROM maven as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean test package

FROM openjdk:18-jdk-alpine
WORKDIR /usr/app
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","s6-0.0.1-SNAPSHOT.jar"]
EXPOSE 8100
