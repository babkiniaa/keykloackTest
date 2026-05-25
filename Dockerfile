FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY target/quarkus-app /app/quarkus-app/

ENTRYPOINT ["java", "-jar" , "quarkus-app/quarkus-run.jar"]