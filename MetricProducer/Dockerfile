FROM amazoncorretto:21-alpine-jdk
LABEL authors="Daniyal"
COPY target/*.jar app.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "/app.jar"]