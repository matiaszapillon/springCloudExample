# springCloudExample
Small project created using Spring Cloud projects

Steps:
1 - Start up discovery-server to be able to start registering the services;
    - mvn spring-boot:run
    - Test entering to: http://localhost:8761/actuator/health

2 - Start up services and register them to discovery-server.
    - If you want to run only 1 instance, just go to service-example and run 'mvn spring-boot:run'
    - If you want to run multiple instances (This is what we are doing to see how discovery-server works) you have to overwrite the 'service.instance.name' from the application.yml
    - so: Open two different consoles and run: 
        java -jar -Dserver.port=9091 -Dservice.instance.name=intance1 target/service-example-0.0.1-SNAPSHOT.jar
        java -jar -Dserver.port=9092 -Dservice.instance.name=intance2 target/service-example-0.0.1-SNAPSHOT.jar
    - Then check both instance separately and also check http://localhost:8761/ to see if both instances appears there

3 - Start up client service. Go to /client and run 'mvn spring-boot:run'.
    - Test discovery client. curl http://localhost:8080/service-name . If every went Ok, you should see the response from 'service-example' for both instance. 
    - If there was a Load Balancer, the service-example would use the available instance. In this case, if there are 2 instances, The response will come 
      once for each instance.

4 - //TODO [Config cliente and config server]
