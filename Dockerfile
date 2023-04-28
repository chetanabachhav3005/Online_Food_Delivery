FROM openjdk:8
EXPOSE 8282
ADD Online-Food-Delivery-0.0.1-SNAPSHOT.jar  Online-Food-Delivery-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","/Online-Food-Delivery-0.0.1-SNAPSHOT.jar" ]