# Simple Spring 5 Web App

A spring web application using `spring-boot-starter-web` and `spring-boot-starter-data-jpa` to create a simple entity model backed by simple CRUD operations.  Created by following along with Spring Framework 5: Beginner to Guru Udemy course.

# Model

A simple many to many relationship between `Author` and `Book` tables;

![er diagram](docs/images/er-diagram.png)

# Entities

- [Author](src\main\java\com\clarsen\sandbox\udemy\spring\spring5webapp\domain\Author.java)  
- [Book](src\main\java\com\clarsen\sandbox\udemy\spring\spring5webapp\domain\Book.java)  

# Requirements

- Java 11+
- Maven build tools 

# How to Run

1. clone repository
2. open `spring5webapp` folder
3. issue command `mvn spring-boot:run`
4. will be able to issue any request after start up logs have completed with
    > INFO 11500 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''  
    > INFO 11500 --- [           main] c.c.s.u.s.s.Spring5webappApplication     : Started Spring5webappApplication in 2.54 seconds (JVM running for 2.79)  

# Requests

## get books view
```
cUrl -X GET "http://localhost:8080/books"
```