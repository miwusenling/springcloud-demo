1. 在单一ecs, 单一docker容器部署的配置.
eureka:
  client:
    serviceUrl:
      defaultZone: http://172.17.0.2:8080/eureka/
      
  instance:
    instance-id: http://172.17.0.9:${server.port}
    prefer-ip-address: true
    ip-address: 172.17.0.9
      
server:
  port: 8087
spring:
  application:
    name: service-zuul
zuul:
  routes:
    api-a:
      path: /api-a/**
      serviceId: consumer-helloService-byRibbon
    api-b:
      path: /api-b/**
      serviceId: consumer-helloService-byFeign

2. 在多ecs, 多个docker容器部署的配置. 部署与slave1
eureka:
  client:
    serviceUrl:
      defaultZone: http://39.100.137.85:8080/eureka/
      
  instance:
    instance-id: http://192.168.0.9:${server.port}
    prefer-ip-address: true
    ip-address: 192.168.0.9
      
server:
  port: 8087
spring:
  application:
    name: service-zuul
zuul:
  routes:
    api-a:
      path: /api-a/**
      serviceId: consumer-helloService-byRibbon
    api-b:
      path: /api-b/**
      serviceId: consumer-helloService-byFeign
      
      
      
      
      
      
      
3. k8s 配置: 需要修改的文件. 


eureka:
  client:
    serviceUrl:
      defaultZone: http://39.100.137.85:30000/eureka/
      
  instance:
    #instance-id: http://172.17.0.9:${server.port}
    prefer-ip-address: true
    #ip-address: 172.17.0.9
      
server:
  port: 8087
spring:
  application:
    name: service-zuul
zuul:
  routes:
    api-a:
      path: /api-a/**
      serviceId: consumer-helloService-byRibbon
    api-b:
      path: /api-b/**
      serviceId: consumer-helloService-byFeign
      
   
pom.xml

<build>
		<finalName>springcloud-zuul-server</finalName>
</build>


Dockerfile

ADD ./target/springcloud-zuul-server.jar /software/dockerImage/springcloud-zuul-server.jar

ENTRYPOINT ["java", "-jar", "/software/dockerImage/springcloud-zuul-server.jar"]




springcloud-helloconsumer-zuul.yaml   

apiVersion: apps/v1
kind: Deployment
metadata:
  name: springcloud-helloconsumer-zuul
  labels:
    app: springcloud-helloconsumer-zuul
spec:
  replicas: 2
  selector:
    matchLabels:
      app: springcloud-helloconsumer-zuul
  template:
    metadata:
      labels:
        app: springcloud-helloconsumer-zuul
    spec:
      containers:
        - name: springcloud-helloconsumer-zuul
          image: 39.100.137.85:5000/springcloud-helloconsumer-zuul:0.0.3
          #imagePullPolicy: Never
          ports:
            - containerPort: 8087
              protocol: TCP
---
apiVersion: v1
kind: Service
metadata:
  name: springcloud-helloconsumer-zuul-service
  labels:
    app: springcloud-helloconsumer-zuul
spec:
  type: NodePort
  selector:
    app: springcloud-helloconsumer-zuul
  ports:
    - protocol: TCP
      port: 8087
      targetPort: 8087
      nodePort: 30007


   



      
      
      