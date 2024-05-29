FROM openjdk:8-jre

ADD spring-learn/target/spring-learn-1.0-SNAPSHOT.jar /application.jar


ENTRYPOINT ["java", "-jar","/application.jar"]