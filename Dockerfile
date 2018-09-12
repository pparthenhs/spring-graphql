FROM openjdk:8u171-jdk-slim

ADD ./target/spring-graphql-1.0.0.jar /app/

CMD java -jar /app/spring-graphql-1.0.0.jar --spring.profiles.active="production"