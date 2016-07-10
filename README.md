# spring_mvc_user_managment
A Basic Simple User Management Aplication Using Spring MVC with Hibernate ORM.

It will do the following operations

1. Create User
2. Read All Users
3. Update User
4. Delete User

###DB Configuration

You can set your database settings here at spring_mvc_user_managment/build/classes/resources/database.properties

MySql:
```sh
database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://localhost:3306/USER_MANAGEMENT
database.user=root
database.password=admin#1
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.show_sql=true
hibernate.hbm2ddl.auto=update
```

HSQLDB:
```sh
database.driver=com.hsqldb.jdbc.Driver
database.url=jdbc:hsqldb:mem:USER_MANAGEMENT
database.user=root
database.password=admin#1
hibernate.dialect=org.hibernate.dialect.HSQLDialect
hibernate.show_sql=true
hibernate.hbm2ddl.auto=update
```




