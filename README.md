## demo



### Aplicación

SpringBoot Application :DemoApplication.java



### Ejecución

`mvn spring-boot:run -P local-dev`



### Configuración

spring:
  application:
    name: demo
  profiles:
    active: dev  # Cambia a "prod" en producción

  datasource:
    url: jdbc:h2:file:./demoDb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    generate-ddl: true
    open-in-view: true
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.H2Dialect
  sql:
    init:
      mode: always
  h2:
    console:
      enabled: true

server:
  servlet:
    context-path: /demo

logging:
  level:
    web: debug




### Versiones

Java Versión: 17

SpringBoot  : 3.1.2



### DB Model Dummy

Model: demoScript.orm

```sql




Table Test_Table {
  id integer [primary key]
  value1 varchar
  value2 varchar
}




### API

[GET] http://localhost:8080/test-table/get/{id}

[GET] http://localhost:8080/test-table/get-all

[POST] http://localhost:8080/test-table/add

[POST] http://localhost:8080/test-table/add-many/



### API

[GET] http://localhost:8080/personas/get/{id}

[GET] http://localhost:8080/personas/get-all

[POST] http://localhost:8080/personas/add

[POST] http://localhost:8080/personas/add-many/



### API

[GET] http://localhost:8080/contratos/get/{id}

[GET] http://localhost:8080/contratos/get-all

[POST] http://localhost:8080/contratos/add

[POST] http://localhost:8080/contratos/add-many/

