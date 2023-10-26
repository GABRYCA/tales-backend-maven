# Welcome to the Tales Java Spring Backend!
This is essentially my personal playground into learning Backend APIs, starting wth java, because that's the language we're using to achieve my Bachelor's Degree.

You may be wondering, what's tales? That's a side project I made in PHP 8.3, essentially it's an arts/posts sharing website, you can view it [here](https://tales.anonymousgca.eu/).

Currently Tales doesn't use this Backend, but it's a monolithic PHP Object Oriented Application, so it's... kind of hard to migrate it to this backend. Anyway I'm planning into migrating it into SvelteKit or React and using this backend.

## Installation:
1. Clone this repository
2. It's recommended to use **IntelliJ Idea Ultimate** to run this project, as it will do all the imports for you
3. Run the project
4. Check if [localhost:8080/hello](http://localhost:8080/hello) returns `"Hello World!"`, if yes, then you're ready to go.

### WARNING:
You should create an application.properties inside src/main/resources and add the following:
```properties
spring.datasource.url=jdbc:mariadb://address:port/db_name
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.datasource.hikari.max-lifetime=590000 
```

**REPLACE THE VALUES WITH YOUR OWN!**

## Swagger:
This project uses Swagger to document the API, you can access it by going to [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Credits and License:
I do not take any responsibility for the usage of this code, it's free to use, but I do not guarantee it will work as intended, or that it will work at all.
