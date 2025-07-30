FROM openjdk:17
WORKDIR /app
COPY target/user-auth-service-0.0.1-SNAPSHOT.jar AuthService.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "AuthService.jar"]