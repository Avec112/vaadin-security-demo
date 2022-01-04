# Vaadin (Flow) Security Demo

The application is a simple demonstration of Vaadin integrated with Spring Boot and Spring Security.
A local in-memory database (H2) is created with tables `users` and `authorities`.

The application is based on two separate examples: 
* Vaadin Tutorial [Securing your app with Spring Security](https://vaadin.com/learn/tutorials/securing-your-app-with-spring-security)
* Java Brains showing [Spring Boot + Spring Security with JPA authentication and MySQL from scratch](https://www.youtube.com/watch?v=TNt3GHuayXs&list=PL7sN6F00MxZbcUxfVSHscl72fH_K2-35l) (Youtube)

## Interesting files
* schema.sql (creating tables)
* data.sql (populating tables)
* SecurityConfiguration.java (from Vaadin Tutorial)
* SecurityUtils.java (from Vaadin tutorial)
* MainView.java (line 108, showing menu by authorization)
* Other Views using annotation @Secured

## Requirements
* Maven 3.6+
* Java 1.8+

## Dependencies
* Vaadin 14+
* Spring Boot 2.4+

## Run Application
* Method 1: Start application (Application.java) from IDE
* Method 2: `mvn spring-boot:run` 

## Access Application
* Start Application first
* Access http://localhost:8080 
* Login with users
  * `guest/guest` (has no priveliges except for authenticated user)
  * `user/user` (has restricted privileges. Can see something guest cannot)
  * `admin/admin` (has all privileges. Can see everything)
