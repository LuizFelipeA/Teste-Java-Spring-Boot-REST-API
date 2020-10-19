# Teste Java Spring Boot REST API
REST API based on Java Spring, Spring Boot, Hibernate ORM with MySQL and Spring Fox (Swagger API docs)

SQL scripts in the folder called "SQL"

### Starter project
Generate .jar
```sh
$ mvn clean install
```
After that, up the containers Docker
```sh
$ docker-compose up --build --force-recreate
```
Obs: By default, the Docker will expose port 8080(Application) and 3306(MySQL), so change this within the Dockerfile if necessary.

## REST API Endpoints

All inputs and outputs use JSON format.

**To open Swagger (interactive) API documentation, navigate your browser to [YOUR-URL]/swagger-ui.html**

```
/user
  GET / - List of users with filters by any field
  POST / - Add user - required : String name , String email, Date birthdate
  PUT /{id} - Update user
  
/order
  GET / - List of orders with filters by any field
  POST / - Add order - required : String name , String email, Date birthdate
```
