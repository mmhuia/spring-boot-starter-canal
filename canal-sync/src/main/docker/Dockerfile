FROM java:8

VOLUME ./tmp

ADD canal-sync-0.0.1-SNAPSHOT.jar canal-sync-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch app.jar'

EXPOSE 8081

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/canal-sync-0.0.1-SNAPSHOT.jar"]


