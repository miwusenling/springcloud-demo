#FROM java:8-jre
FROM java:8
MAINTAINER lzhw <f-16cd@163.com>

#ADD SpringCloud-HelloService-1.jar /software/dockerImage/springcloud-helloservice-1.jar
#VOLUME /software/code/SpringCloud-Eureka.jar /software/dockerImage/springcloud-helloservice-1.jar

#ARG JAR_FILE
#ADD ${JAR_FILE} /software/dockerImage/springcloud-helloservice-1.jar
ADD ./target/springcloud-zuul-client.jar /software/dockerImage/springcloud-zuul-client.jar

EXPOSE 8089

#CMD ["java", "-jar", "/software/dockerImage/springcloud-helloservice-1.jar"]
ENTRYPOINT ["java", "-jar", "/software/dockerImage/springcloud-zuul-client.jar"]

