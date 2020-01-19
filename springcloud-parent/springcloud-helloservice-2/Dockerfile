#鍦╠ocker鐜涓嬫墜鍔ㄥ埗浣滈暅鍍�
#FROM java:8-jre
FROM java:8
MAINTAINER lzhw <f-16cd@163.com>

# jar鏂囦欢鍜宒ockerfile鏂囦欢鍦ㄥ悓涓�涓洰褰�(鎸囧畾婧恓ar璺緞浼氬嚭閿�)
#ADD SpringCloud-HelloService-2.jar /software/dockerImage/springcloud-helloservice-2.jar
#VOLUME /software/code/SpringCloud-Eureka.jar /software/dockerImage/springcloud-helloservice-2.jar

#ARG JAR_FILE
#ADD ${JAR_FILE} /software/dockerImage/springcloud-helloservice-2.jar
ADD ./target/springcloud-helloservice-2.jar /software/dockerImage/springcloud-helloservice-2.jar

EXPOSE 8082

#CMD ["java", "-jar", "/software/dockerImage/springcloud-helloservice-2.jar"]
ENTRYPOINT ["java", "-jar", "/software/dockerImage/springcloud-helloservice-2.jar"]

#鎵嬪姩鍒朵綔闀滃儚缁撴潫