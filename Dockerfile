FROM openjdk:8-jdk-alpine

RUN addgroup -g 1000 bd
RUN adduser -u 1000 -G bd -D bd

RUN mkdir -p /mydiet/run
RUN mkdir -p /mydiet/logs
RUN mkdir -p /mydiet/lib
COPY target/mydiet-0.0.1-SNAPSHOT.jar /mydiet/lib/app.jar
RUN chown -R bd:bd /mydiet
USER bd

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=prod","/mydiet/lib/app.jar"]

