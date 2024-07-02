FROM alpine:3.19
 
RUN apk update --no-cache
 
RUN apk upgrade --no-cache
 
RUN apk add openjdk17=17.0.11_p9-r0 --no-cache
 
RUN rm -rf /var/cache/apk/*
 
WORKDIR /opt
 
RUN wget https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz
 
RUN tar -xzf apache-maven-3.9.6-bin.tar.gz
 
RUN rm -rf apache-maven-3.9.6-bin.tar.gz
 
ENV M2_HOME="/opt/apache-maven-3.9.6"
 
ENV PATH=$PATH:$M2_HOME/bin
 
WORKDIR /app
 
#RUN mvn package -Dquarkus.package.type=uber-jar
 
CMD [ "/bin/sh" ]
 