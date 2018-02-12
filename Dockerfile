FROM anapsix/alpine-java
MAINTAINER Vitaly
RUN mkdir /home/log/
EXPOSE 80
COPY nget-1.jar /home/frwall-0.0.1-SNAPSHOT.jar
COPY lib /home/lib
CMD ["java","-jar","/home/frwall-0.0.1-SNAPSHOT.jar"]