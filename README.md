# CameraIQ Api
Design and implement a simple application serving a RESTful API to perform operations on Organization as well as
Users.

## Project Dependency:
Jave 1.8 +
Maven 4.0
pringframework.boot:  spring-boot-starter-data-rest, spring-boot-starter-data-jpa
MySQL 

## Installation & Run

```
# Download this project
git clone git@github.com:aerilxx/CameraIQ.git

# Before running API server, you should set the database config with yours or set the your database config in application.properties 
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/interview_api?serverTimezone=UTC
spring.datasource.username=ENVIRON_USERNAME
spring.datasource.password=ENVIRON_PASSWORD 

# Run 
mvn spring-boot:run

```
## API
API Endpoint : http://127.0.0.1:8080

1. GET: 
 * display all users in the db :  http://127.0.0.1:8080/api/user
 * display all organization in the db :  http://127.0.0.1:8080/api/organization
 * Read all Users who belong to a speciﬁc Organization:  http://127.0.0.1:8080/api/organization/{orgId}
 * Read all Organizations to which a User belongs:  http://127.0.0.1:8080/api/user//{userId}/organization
 
2. POST 
* Create a single Organization: http://127.0.0.1:8080/api/organization 
* Create a single User : http://127.0.0.1:8080/api/user
* Add a User to an Organization : http://127.0.0.1:8080/api/organization/{orgId}/add/{userId}

3. DETELE
* Delete a User from an Organization : http://127.0.0.1:8080/api/organization/{orgId}/delete/{userId}
