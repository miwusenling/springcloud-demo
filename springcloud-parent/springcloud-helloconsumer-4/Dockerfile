#FROM java:8-jre
FROM java:8
MAINTAINER lzhw <f-16cd@163.com>

#ADD SpringCloud-HelloConsumer-1.jar /software/dockerImage/springcloud-helloconsumer-1.jar
#VOLUME /software/code/SpringCloud-Eureka.jar /software/dockerImage/springcloud-helloconsumer-1.jar

#ARG JAR_FILE
#ADD ${JAR_FILE} /software/dockerImage/springcloud-helloconsumer-1.jar
ADD ./target/springcloud-helloconsumer-4.jar /software/dockerImage/springcloud-helloconsumer-4.jar

EXPOSE 8086

#CMD ["java", "-jar", "/software/dockerImage/springcloud-helloconsumer-4.jar"]
ENTRYPOINT ["java", "-jar", "/software/dockerImage/springcloud-helloconsumer-4.jar"]
