# Project Documentation: Java-SQL-Docker Web Application

This document provides a detailed overview of the project structure, the frameworks and technologies used, and the steps required to deploy and run the application once it is complete.

---

## Project Overview

This project is a web application built using **Java**, **SQL Server**, and **Docker**. The purpose is to demonstrate how to build a Java web application that connects to a database (SQL Server) and deploy it within Docker containers. 

The application allows users to register via a form and store their information (username, password, full name, and email) in a SQL Server database.

---

## Technologies and Frameworks

### 1. **Java** (JDK 8+)
   - The core language used to build the backend of the application.
   - **JDBC** is used to connect to the SQL Server database.
   - **Servlets** handle HTTP requests, such as user registration.

### 2. **SQL Server** (Microsoft SQL Server 19+)
   - A relational database management system used to store user information.
   - The application interacts with the database through **SQL queries** via **JDBC**.

### 3. **Docker**
   - Docker is used to containerize both the Java application and the SQL Server.
   - **Docker Compose** is used to orchestrate multiple containers (Java app + SQL Server).

### 4. **JSP (Java Server Pages)**
   - **JSP** is used for creating the front-end user interface for registration.
   - Pages like `index.jsp`, `success.jsp`, and `error.jsp` are used for user interaction.

### 5. **Maven** (Dependency Management)
   - **Maven** is used for managing the project dependencies, such as the **SQL Server JDBC driver** and **Servlet API**.

---

## Project Structure

Here’s an overview of the project's folder and file structure:
[view in lucid.app](https://lucid.app/lucidchart/add0721e-58c0-4285-a141-464f94879c76/edit?viewport_loc=207%2C-1184%2C3848%2C2579%2C0_0&invitationId=inv_f0a86356-7243-49ab-ac16-dbb30e939abb)
### Database Information
[view in dbdiagram.iio](https://dbdiagram.io/d/users-67127a9a97a66db9a37b07c9)
SQL Server Container Details:
+ Image: mcr.microsoft.com/mssql/server:2019-latest
+ Port: `1433`
Default Credentials:
+ Username: `sa`
+ Password: `1234567`

Database Setup:
A database named `webNote` should be created during initialization.
The `Users` table is created to store registration details.
