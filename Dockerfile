FROM eclipse-temurin:21-jre-jammy
EXPOSE 8080
COPY target/github-actions-demo.jar github-actions-demo.jar
ENTRYPOINT ["java", "-jar", "github-actions-demo.jar"]