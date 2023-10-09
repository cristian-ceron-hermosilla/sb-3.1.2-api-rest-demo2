# NameNormalize(nameOri=demo, name1May=Demo, name1min=demo, nameWithGuion=demo)

## Ejecución
`mvn spring-boot:run -P local-dev`

##Versiones
Java Versión: 17
SpringBoot  : 3.1.2

##DB Model Dummy
Model: demoScript.orm
```sql
// Use DBML to define your database structure
// Docs: https://dbml.dbdiagram.io/docs

// -----------------------------------------------------
// folder:  C:\_GITHUB\workspace\sb-3.1.2-api-rest-demo2/src/main/java/com/example/demo\
// package: com.example.demo
// -----------------------------------------------------


// -----------------------------------------------------
// 
Table Test_Table {
  id integer [primary key]
  value1 varchar
  value2 varchar
}

