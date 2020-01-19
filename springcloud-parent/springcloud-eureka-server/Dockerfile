#在docker环境下手动制作镜像
#FROM java:8-jre
FROM java:8
MAINTAINER lzhw <f-16cd@163.com>

# dockerfile文件与pom文件在同一个目录
#ADD SpringCloud-Eureka.jar /software/dockerImage/springcloud-eureka-server.jar
#VOLUME /software/code/SpringCloud-Eureka.jar /software/dockerImage/springcloud-eureka-server.jar

# 直接打包, 依赖于dockerfile插件
#ARG JAR_FILE
#ADD ${JAR_FILE} /software/dockerImage/springcloud-eureka-server.jar

# description path: /software/dockerImage/springcloud-eureka-server.jar : the store path in the docker container

# 直接打包, 不依赖于dockerfile插件
ADD ./target/springcloud-eureka-server.jar /software/dockerImage/springcloud-eureka-server.jar

EXPOSE 8080

#CMD ["java", "-jar", "/software/dockerImage/springcloud-eureka-server.jar"]
ENTRYPOINT ["java", "-jar", "/software/dockerImage/springcloud-eureka-server.jar"]

#手动制作镜像结束