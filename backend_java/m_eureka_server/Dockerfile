FROM openjdk:8-jdk

LABEL maintainer="muk214782@gmail.com"

WORKDIR /app

COPY target/m_eureka_server-0.0.1-SNAPSHOT.jar /app/m_eureka_server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "m_eureka_server-0.0.1-SNAPSHOT.jar"]