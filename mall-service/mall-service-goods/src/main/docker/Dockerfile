FROM openjdk:8-jdk-alpine
RUN apk add tzdata
RUN addgroup -S domi && adduser -S -u 1000 domimall -G domi
USER domimall:domi
VOLUME /tmp
ADD *.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]