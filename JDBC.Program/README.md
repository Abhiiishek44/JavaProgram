# Simple Student JDBC CRUD

A minimal Java console app to manage student records with JDBC. It uses prepared statements and basic transaction handling (commit/rollback).

## Database Setup

Run the SQL in `schema.sql` to create the `students` table.

## Configure Connection

Edit these constants in `StudentJDBC.java` if needed:

- `URL` (MySQL example: `jdbc:mysql://localhost:3306/testdb`)
- `USER`
- `PASS`

PostgreSQL example URL: `jdbc:postgresql://localhost:5432/testdb`

## How to Run

1. Add the JDBC driver jar to the classpath.
2. Compile and run:

```
javac StudentJDBC.java
java StudentJDBC
```
