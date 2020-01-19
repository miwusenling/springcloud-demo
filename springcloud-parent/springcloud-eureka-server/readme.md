1. 在单一ecs, 单一docker容器部署的配置.
server:
  port: 8080
 
eureka:
  instance:
    hostname: localhost
    #hostname: 172.17.0.2
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url: 
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

      
2. 在多ecs, 多个docker容器部署的配置.  部署与master
   

3. k8s 配置: springcloud-eureka.yaml   
            
apiVersion: apps/v1
kind: Deployment
metadata:
  name: springcloud-eureka
  labels:
    app: springcloud-eureka
spec:
  replicas: 1
  selector:
    matchLabels:
      app: springcloud-eureka
  template:
    metadata:
      labels:
        app: springcloud-eureka
    spec:
      containers:
        - name: springcloud-eureka
          image: 39.100.137.85:5000/springcloud-eureka:0.0.1
          #imagePullPolicy: Never
          ports:
            - containerPort: 8080
              protocol: TCP
---
apiVersion: v1
kind: Service
metadata:
  name: springcloud-eureka-service
  labels:
    app: springcloud-eureka
spec:
  type: NodePort
  selector:
    app: springcloud-eureka
  ports:
    - protocol: TCP
      port: 8080
      targetPort: 8080
      nodePort: 30000






     






   