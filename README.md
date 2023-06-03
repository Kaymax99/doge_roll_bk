# VTT RPG Platform Doge Roll Rest API
Java SpringBoot based Rest API required for the usage of the VTT RPG Platform Doge Roll <br>
It works automatically as all CRUD operations are called through frontend and no actualy input is required outside of initial configuration.

## Required User Interface
This API exists to be used alongside frontend application <a href="https://github.com/Kaymax99/doge_roll_fnt">Doge Roll</a>

## Tech Stack
<ul>
  <li>Java</li>
  <li>Spring Boot | Web | Security</li>
  <li>Json Web Token</li>
  <li>PostgreSQL</li>
  <li>Lombok</li>
</ul>

## Setup
Navigate to folder <code>src/main/resources</code> and open/create application.properties file. Include the following: <br>

<code>spring.datasource.driver-class-name=org.postgresql.Driver<br>
spring.datasource.url=jdbc:postgresql://localhost:5432/DATABASENAME (or whichever port/url you use)<br>
spring.datasource.username=USERNAME<br>
spring.datasource.password=PASSWORD</code>

<code>spring.jpa.properties.hibernate.default_schema=public<br>
spring.jpa.hibernate.ddl-auto = update<br>
spring.jpa.show-sql=true<br>
spring.jpa.properties.hibernate.format_sql=true<br>
spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false<br>
app.jwt-secret=YOUR CUSTOM JWT KEY<br>
app.jwt-expiration-milliseconds=604800000<br></code>

And that's it really! On first application run a database will be created with the name you provided, and you may use apps like pgAdmin to view its content, which will be automatically handled by the frontend as you register and create games/characters.
