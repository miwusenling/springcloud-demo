1. 在单一ecs, 单一docker容器部署的配置.
server:
  port: 8086
spring:
  application:
    name: consumer-helloService-byFeign


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://172.17.0.2:8080/eureka/
      
  instance:
    instance-id: http://172.17.0.8:${server.port}
    prefer-ip-address: true
    ip-address: 172.17.0.8
   
feign:
  hystrix:
    enabled: true

2. 在多ecs, 多个docker容器部署的配置. 部署与slave2
server:
  port: 8086
spring:
  application:
    name: consumer-helloService-byFeign


eureka:
  client:
    serviceUrl:
      #defaultZone: http://localhost:8080/eureka/
      defaultZone: http://39.100.137.85:8080/eureka/
      
  instance:
    instance-id: http://192.168.0.8:${server.port}
    prefer-ip-address: true
    ip-address: 192.168.0.8
   
feign:
  hystrix:
    enabled: true