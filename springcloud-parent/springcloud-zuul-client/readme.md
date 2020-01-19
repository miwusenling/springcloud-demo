1. 在单一ecs, 单一docker容器部署的配置.
server:
  port: 8089
spring:
  application:
    name: springcloud-zuul-client


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://172.17.0.2:8080/eureka/
      
  instance:
    instance-id: http://172.17.0.11:${server.port}
    prefer-ip-address: true
    ip-address: 172.17.0.11 
   
feign:
  hystrix:
    enabled: true
    
management:
    endpoints:
       web:
          exposure:
             include: "*"     


2. 在多ecs, 多个docker容器部署的配置. 部署与slave1
server:
  port: 8089
spring:
  application:
    name: springcloud-zuul-client


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://39.100.137.85:8080/eureka/
      
  instance:
    instance-id: http://192.168.0.11:${server.port}
    prefer-ip-address: true
    ip-address: 192.168.0.11 
   
feign:
  hystrix:
    enabled: true
    
management:
    endpoints:
       web:
          exposure:
             include: "*"    


3. 此微服务模拟web客户端调用zuul集群服务.

4. 



