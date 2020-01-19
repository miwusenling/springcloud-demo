1. 在单一ecs, 单一docker容器部署的配置.
server:
  port: 8081

spring:
  application:
    name: service-hi

eureka:
  client:
    serviceUrl:
       #defaultZone: http://localhost:8080/eureka/
       defaultZone: http://172.17.0.2:8080/eureka/
       
  instance:
    instance-id: http://172.17.0.3:${server.port}
    prefer-ip-address: true
    ip-address: 172.17.0.3


2. 在多ecs, 多个docker容器部署的配置. 部署于master
server:
  port: 8081

spring:
  application:
    name: service-hi

eureka:
  client:
    serviceUrl:
       #defaultZone: http://localhost:8080/eureka/
       defaultZone: http://39.100.137.85:8080/eureka/
       
  instance:
    instance-id: http://192.168.0.3:${server.port}
    prefer-ip-address: true
    ip-address: 192.168.0.3
    

    
3. k8s 配置: 需要修改的文件. 

application.yml

server:
  port: 8081

spring:
  application:
    name: service-hi

eureka:
  client:
    serviceUrl:
       #defaultZone: http://localhost:8080/eureka/
       defaultZone: http://39.100.137.85:30000/eureka/
       
  instance:
    #instance-id: http://192.168.0.3:${server.port}
    prefer-ip-address: true
    #ip-address: 192.168.0.3
    
    
pom.xml

.....

<build>
		<finalName>springcloud-helloservice</finalName>
</build>


Dockerfile:

ADD ./target/springcloud-helloservice.jar /software/dockerImage/springcloud-helloservice.jar

ENTRYPOINT ["java", "-jar", "/software/dockerImage/springcloud-helloservice.jar"]


springcloud-helloservice.yaml

apiVersion: apps/v1
kind: Deployment
metadata:
  name: springcloud-helloservice
  labels:
    app: springcloud-helloservice
spec:
  replicas: 2
  selector:
    matchLabels:
      app: springcloud-helloservice
  template:
    metadata:
      labels:
        app: springcloud-helloservice
    spec:
      containers:
        - name: springcloud-helloservice
          image: 39.100.137.85:5000/springcloud-helloservice:0.0.3
          #imagePullPolicy: Never
          ports:
            - containerPort: 8081
              protocol: TCP
---
apiVersion: v1
kind: Service
metadata:
  name: springcloud-helloservice-service
  labels:
    app: springcloud-helloservice
spec:
  type: NodePort
  selector:
    app: springcloud-helloservice
  ports:
    - protocol: TCP
      port: 8081
      targetPort: 8081
      nodePort: 30001


4. 测试多ecs节点部署，不指定Ip 的情况。 部署于master
server:
  port: 8081

spring:
  application:
    name: service-hi

eureka:
  client:
    serviceUrl:
       #defaultZone: http://localhost:8080/eureka/
       defaultZone: http://39.100.137.85:8080/eureka/
       
  instance:
    #instance-id: http://192.168.0.3:${server.port}
    prefer-ip-address: true
    #ip-address: 192.168.0.3










    
    
    
