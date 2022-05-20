FROM maven as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean test package

FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine
WORKDIR /usr/app
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
