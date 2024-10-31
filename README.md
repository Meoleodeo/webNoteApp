# Java + SQL Server Web Application with Docker

> [Description](#description) | [How to run](#how-to-run-the-application) | [Release](#download-the-latest-release) | [Screenshot Demo](#screenshot) | [Main Features include](#main-features-include) | [Tutorial](#tutorial)

## Description:
This project demonstrates a simple Java web application that connects to a SQL Server database using JDBC. The application allows users to register their accounts and stores their information (username, password, full name, email) in a SQL Server database.

The application is containerized using Docker, with services managed by Docker Compose for ease of deployment and scalability.
> [_Video-Demo_](https://youtu.be/@meoleodeo)
Author: 
+ [_Mèo leo đèo_](https://github.com/meoleodeo)

## How to Run the Application
### 1. Clone the Repository

```bash
git clone https://github.com/Meoleodeo/webNoteApp.git
cd .\webNoteApp
echo success
```
### 2. build Docker Images:
Build the Docker images for both the Java web app and SQL Server:
```bash
docker-compose build

```
### 3. Start the Services
Run the following command to start both the SQL Server and Java app services:
```bash
docker-compose up
```
Once the services are running, you can access the web application at:
```bash
http://localhost:8080/index.jsp
```
### 4. Stopping the Services
After you're done using the application, you can stop the containers by running:
```bash
docker-compose down
```
This will stop and remove the running containers.

## Main Features include:
- Depends on [version](https://github.com/Meoleodeo/webNoteApp/releases)
- update later

## [_Download the latest release!!_](https://github.com/Meoleodeo/webNoteApp/releases)

## Screenshot:
![DEMO](./screenshoot/DemoLv1.png)
