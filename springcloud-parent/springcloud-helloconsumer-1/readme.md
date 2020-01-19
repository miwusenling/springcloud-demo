1. 在单一ecs, 单一docker容器部署的配置.
server:
  port: 8083
spring:
  application:
    name: consumer-helloService-byRibbon


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://172.17.0.2:8080/eureka/
      
  instance:
    instance-id: http://172.17.0.5:${server.port}
    prefer-ip-address: true
    ip-address: 172.17.0.5

2. 在多ecs, 多个docker容器部署的配置. 部署于slave1

server:
  port: 8083
spring:
  application:
    name: consumer-helloService-byRibbon


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://39.100.137.85:8080/eureka/
      
  instance:
    instance-id: http://192.168.0.5:${server.port}
    prefer-ip-address: true
    ip-address: 192.168.0.5
    
    



    
3. k8s 配置: 需要修改的文件. 

application.yml

server:
  port: 8083
spring:
  application:
    name: consumer-helloService-byRibbon


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://39.100.137.85:30000/eureka/
      
  instance:
    #instance-id: http://172.17.0.5:${server.port}
    prefer-ip-address: true
    #ip-address: 172.17.0.5


pom.xml

.....

<build>
		<finalName>springcloud-helloconsumer</finalName>
</build>



Dockerfile:

ADD ./target/springcloud-helloconsumer.jar /software/dockerImage/springcloud-helloconsumer.jar
......
ENTRYPOINT ["java", "-jar", "/software/dockerImage/springcloud-helloconsumer.jar"]



springcloud-helloconsumer-ribbon.yaml

apiVersion: apps/v1
kind: Deployment
metadata:
  name: springcloud-helloconsumer-ribbon
  labels:
    app: springcloud-helloconsumer-ribbon
spec:
  replicas: 2
  selector:
    matchLabels:
      app: springcloud-helloconsumer-ribbon
  template:
    metadata:
      labels:
        app: springcloud-helloconsumer-ribbon
    spec:
      containers:
        - name: springcloud-helloconsumer-ribbon
          image: 39.100.137.85:5000/springcloud-helloconsumer-ribbon:0.0.3
          #imagePullPolicy: Never
          ports:
            - containerPort: 8083
              protocol: TCP
---
apiVersion: v1
kind: Service
metadata:
  name: springcloud-helloconsumer-ribbon-service
  labels:
    app: springcloud-helloconsumer-ribbon
spec:
  type: NodePort
  selector:
    app: springcloud-helloconsumer-ribbon
  ports:
    - protocol: TCP
      port: 8083
      targetPort: 8083
      nodePort: 30003


4. 测试多ecs节点部署，不指定Ip 的情况。 部署于slave1
   
server:
  port: 8083
spring:
  application:
    name: consumer-helloService-byRibbon


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://39.100.137.85:8080/eureka/
      
  instance:
    #instance-id: http://192.168.0.5:${server.port}
    prefer-ip-address: true
    #ip-address: 192.168.0.5











    
    