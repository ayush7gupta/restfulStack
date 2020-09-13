FROM openjdk:8u151-jre-alpine
MAINTAINER ayus7gupta@gmail.com
COPY build/libs/restful-stack-1.0.jar restful-stack.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/restful-stack.jar"]