FROM openjdk:21-jdk-slim
VOLUME /tmp
EXPOSE 8099
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/spring-boot-redis-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]
