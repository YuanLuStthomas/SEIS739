# SEIS739

Repository : https://github.com/YuanLuStthomas/SEIS739

## Full-stack application project

Website will have users who can buy an array or products in different quantities. It will hold the inventory of stock and allow users to make orders to ship to their address.

## What does our tech stack look like?

* Front-end: AngularJS
* Back-end: Spring
* Database engine: SQL server (created in Aiven similar to [this assignment](https://stthomas.instructure.com/courses/69116/files/8341755?module_item_id=2918632))

## `application.properties`

**IMPORTANT**: Replace the following contents in your local `bookblend-backend/src/main/resources/application.properties` BUT with the credentials to our database which I emailed you guys:

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

## Prerequisites

* `npm install -g @angular/cli` : https://angular.io/guide/setup-local#install-the-angular-cli
* `brew install node` : https://formulae.brew.sh/formula/node
* `brew install maven`: https://formulae.brew.sh/formula/maven
* Assuming you already have `java` installed
* Spring docs for reference: https://www.baeldung.com/spring-boot

There might be some others too but if so, just update this list

## Run Application

### Start the Backend Server

To run the backend server, `cd` into `bookblend-backend`, and run the following command:

`./mvnw spring-boot:run`

.. Keep this running while you are testing / view the app

To view our `books` table, you can see that at:

`http://localhost:8080/book`

### Start the Frontend Server

To run the frontend server, open a new terminal `cd` into `bookblend-frontend`.

You will probably need to install dependencies for project first :

`npm install`

To start the Angular server run the following command:

`./ng serve`

.. Keep this running while you are testing / view the app

The frontend site is hosted at :

`http://localhost:4200/`

## Connecting to Our Database via CLI

### Setup CLI

After installing `mysql` :

`brew install mysql`

### Connection

You can connect to our database in your terminal with the following command:

```terminal
mysql --user XXXXX --password=XXXXX --host XXXXX --port 14068 defaultdb
```

[Here](https://aiven.io/docs/products/mysql/howto/connect-from-cli) are the docs if you're having trouble.

### Setup Postgres Database

We have a script in the root of our source code, `insertDummyDataForBookBlend.sql`, that once you're connected to the database via cli, you can run the script on your local maching with the following command:

```terminal
source /Users/apafko/gradSchool/SEIS-739/SEIS739/bookblend-backend/insertDummyDataForBookBlend.sql
```

**⬆️ REPLACE THE FULL PATH WITH WHERE EVER THE SCRIPT IS LOCATED ON YOUR MACHINE ⬆️**

Tip: If you right-click on the file in the left-hand side window in VS Code (or whatever code editor you use), and click `Copy Path`, you can easily replace the full path in the `source` query above.

![alt text](Images/copy_path.png)

If you successfully conncected to the DB and run the script from your local machine, it should look something like:

![alt text](Images/setup_db.png)

## Info About Project

* Tutorial we referenced for setting up the backend (didn't go further than episode 8): https://www.youtube.com/playlist?list=PLtBt-olBU9cTm-5SdTy3mjaSEnHglK-Mz
* Doc we referenced on how to connect the backend to the frontend : https://www.baeldung.com/spring-boot-angular-web 
Added Spring boot security to our app
* Temporarily put an endpoint for users to login and receive a JWT
* Have endpoint for all of the products available
* Have endpoint for all of the orders for the  user signed in
* Have endpoint to see all users in system
* Make all endpoints secured by authentication by default: we check to see if auth principal provided already, if not we will reject with 401 unauthorized
* Put exclusions to requiring authentication on specific endpoints
