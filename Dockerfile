FROM maven:3.6.0-jdk-8-alpine

COPY src /home/SampleProject/src

COPY pom.xml /home/SampleProject

COPY testng.xml /home/SampleProject

RUN mvn -f /home/SampleProject/pom.xml clean test -DskipTests=true