# SEIS739

Full-stack application project

* Added initial code , test controller, exposed the mappings actuator functionality inside spring boot : https://www.youtube.com/watch?v=S7nVCB1Fqvk&list=PLtBt-olBU9cTm-5SdTy3mjaSEnHglK-Mz 

Website will have users who can buy an array or products in different quantities. It will hold the inventory of stock and allow users to make orders to ship to their address.

## What does our tech stack look like?

* Front-end: AngularJS
* Back-end: Spring
* Database engine: SQL server (created in Aiven similar to [this assignment](https://stthomas.instructure.com/courses/69116/files/8341755?module_item_id=2918632))

* Added Spring boot security to our app
* Temporarily put an endpoint for users to login and receive a JWT


What the `bookblend-backend/src/main/resources/application.properties` should look like now but with the credentials to our database which I emailed you guys:

```
spring.application.name=bookblend-backend
management.endpoints.jmx.exposure.exclude=*

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=XXXXX
spring.datasource.username=XXXXX
spring.datasource.password=XXXXX
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Encryption configuration
encryption.salt.rounds=10

# JWT configuration
jwt.algorithm.key=SuperSecureSecretKey
jwt.issuer=eCommerce
jwt.expiryInSeconds=604800
```