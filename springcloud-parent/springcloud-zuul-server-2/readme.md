1. 在单一ecs, 单一docker容器部署的配置.
eureka:
  client:
    serviceUrl:
      defaultZone: http://172.17.0.2:8080/eureka/
      
  instance:
    instance-id: http://172.17.0.10:${server.port}
    prefer-ip-address: true
    ip-address: 172.17.0.10
      
server:
  port: 8088
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


2. 在多ecs, 多个docker容器部署的配置. 部署与slave2
eureka:
  client:
    serviceUrl:
      defaultZone: http://39.100.137.85:8080/eureka/
      
  instance:
    instance-id: http://192.168.0.10:${server.port}
    prefer-ip-address: true
    ip-address: 192.168.0.10
      
server:
  port: 8088
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
