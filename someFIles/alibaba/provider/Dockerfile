FROM java:8
VOLUME /tmp
ADD providerService.jar providerService.jar
ENV TZ=GMT+8
RUN bash -c 'touch /providerService.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/providerService.jar"]
