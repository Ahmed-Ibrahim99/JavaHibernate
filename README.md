# Hibernate CRUD Application

## Overview

This is a simple Java application that demonstrates how to perform CRUD (Create, Read, Update, Delete) operations using **Hibernate** as the ORM framework with **PostgreSQL** as the database. The project does not use any frameworks like Spring but focuses on using Hibernate with pure Java.

## Prerequisites

1. **Java**: Ensure you have Java 8 or later installed.
2. **PostgreSQL**: A running PostgreSQL instance.
3. **Hibernate JAR Files**: Hibernate ORM and PostgreSQL JDBC Driver JAR files (if not using Maven).
4. **Maven** (optional): For dependency management.

## Technologies Used

- Java
- Hibernate ORM
- PostgreSQL Database
- JPA Annotations
- SLF4J Logging (optional)

## Setup and Configuration

### Step 1: Clone the repository

```bash
git clone https://github.com/your-repository/hibernate-crud-example.git
cd hibernate-crud-example
```
### Step 2: Configure PostgreSQL
Create a PostgreSQL database:
```bash
CREATE DATABASE yourDatabase;
```

Update the connection details in hibernate.cfg.xml:

```xml
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/yourDatabase</property>
<property name="hibernate.connection.username">yourUsername</property>
<property name="hibernate.connection.password">yourPassword</property>
```

### Step 3: Run the Application
Run the Main class in src/main/java/com/example/Main.java to test the CRUD operations.

## Conclusion

This project demonstrates how to perform CRUD operations using Hibernate with PostgreSQL and Java.
