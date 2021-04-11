# Test_project

Drivers management CRUD app. Based on Spring Boot with JPA and Hibernate. Data stores on PostgresSQL (username and password in application.properties)

To check project functionality u can use any HTTP debug tool like Postman (https://www.postman.com/downloads/) API:<br>
GET POST PUT http://localhost:8080/bringoz/api/drivers/ <br>
GET DELETE http://localhost:8080/bringoz/api/drivers/{id} <br>
GET http://localhost:8080/bringoz/api/drivers/status/{status} <br>
GET http://localhost:8080/bringoz/api/drivers/location/{north}/{south}/{east}/{west}

Tests included based on Mockito,MockMVC,JUnit4

To launch u need : <br>
Maven<br>
PostgreSQL (https://www.postgresql.org/download/)

Launch guide:
1. git clone https://github.com/AlesLong/Test_project.git
2. mvn spring-boot:run