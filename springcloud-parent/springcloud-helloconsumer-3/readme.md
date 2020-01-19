1. 在单一ecs, 单一docker容器部署的配置.
server:
  port: 8085
spring:
  application:
    name: consumer-helloService-byFeign


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://172.17.0.2:8080/eureka/
      
  instance:
    instance-id: http://172.17.0.7:${server.port}
    prefer-ip-address: true
    ip-address: 172.17.0.7 
   
feign:
  hystrix:
    enabled: true
    
management:
    endpoints:
       web:
          exposure:
             include: "*"    


2. 在多ecs, 多个docker容器部署的配置. 部署于slave1
server:
  port: 8085
spring:
  application:
    name: consumer-helloService-byFeign


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://39.100.137.85:8080/eureka/
      
  instance:
    instance-id: http://192.168.0.7:${server.port}
    prefer-ip-address: true
    ip-address: 192.168.0.7 
   
feign:
  hystrix:
    enabled: true
    
management:
    endpoints:
       web:
          exposure:
             include: "*"    



3. k8s 配置: 需要修改的文件. 

application.yml

server:
  port: 8085
spring:
  application:
    name: consumer-helloService-byFeign


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://39.100.137.85:30000/eureka/
      
  instance:
    #instance-id: http://192.168.0.7:${server.port}
    prefer-ip-address: true
    #ip-address: 192.168.0.7 
   
feign:
  hystrix:
    enabled: true
    
management:
    endpoints:
       web:
          exposure:
             include: "*" 


pom.xml

.....

 <build>
		<finalName>springcloud-helloconsumer</finalName>
 </build>


Dockerfile:
 
 ADD ./target/springcloud-helloconsumer.jar /software/dockerImage/springcloud-helloconsumer.jar
 
 ENTRYPOINT ["java", "-jar", "/software/dockerImage/springcloud-helloconsumer.jar"] 
 




springcloud-helloconsumer-feign.yaml


apiVersion: apps/v1
kind: Deployment
metadata:
  name: springcloud-helloconsumer-feign
  labels:
    app: springcloud-helloconsumer-feign
spec:
  replicas: 2
  selector:
    matchLabels:
      app: springcloud-helloconsumer-feign
  template:
    metadata:
      labels:
        app: springcloud-helloconsumer-feign
    spec:
      containers:
        - name: springcloud-helloconsumer-feign
          image: 39.100.137.85:5000/springcloud-helloconsumer-feign:0.0.3
          #imagePullPolicy: Never
          ports:
            - containerPort: 8085
              protocol: TCP
---
apiVersion: v1
kind: Service
metadata:
  name: springcloud-helloconsumer-feign-service
  labels:
    app: springcloud-helloconsumer-feign
spec:
  type: NodePort
  selector:
    app: springcloud-helloconsumer-feign
  ports:
    - protocol: TCP
      port: 8085
      targetPort: 8085
      nodePort: 30005



 





