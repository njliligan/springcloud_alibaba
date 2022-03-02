FROM java:8
VOLUME /tmp
ADD consumeService.jar consumeService.jar
ENV TZ=GMT+8
RUN bash -c 'touch /consumeService.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/consumeService.jar"]
