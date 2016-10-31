# fresh-tomatoes-server
fresh-tomatoes-server is an api for movie reviews which enables an ability to write movies to database and read movies from a database based on the filter input.

### Version
1.0

### Technology and Framework
Java with Spring Boot

### Installation
Prerequisites - Installation of Java 1.8, Maven and MySQL 

create a schema in mysql
```CREATE SCHEMA `fresh_tomatoes` ```;


Clone the repository of not cloned yet and navigate to server folder
``` git clone https://github.com/tarahs/fresh-tomatoes.git ```

Edit the application properties set appropriate DB propertes
vi fresh-tomatoes-server/src/main/resources/application.properties
```
spring.datasource.url=jdbc:mysql://127.0.0.1/fresh_tomatoes?autoReconnect=true&useSSL=false
spring.datasource.username=   # MySQL DB Username
spring.datasource.password=  # MySQL DB Password
logging.path=
server.port=8080   # If you are setting a different port, you will need to make sure that UI will point to the right port during the proxy_pass throguh nginx

- Navigate to fresh-tomatoes-server directory and run the following command to compile and build Jar.
   ```
    mvn clean install
   ```
- Run the application through one of the following methods,
     - If you are using any IDE like Eclipse, IntelliJ run Application.java as a Java Application
     - OR navigate to fresh-tomatoes-server/target and run the jar using the following Command 
        ```
        $ java -jar fresh-tomatoes-1.0-SNAPSHOT.jar
        ```
