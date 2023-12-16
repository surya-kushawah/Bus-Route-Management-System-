# Bus Management System

The Bus Management System is a Spring Boot application designed to help manage a fleet of buses, including user authentication, bus management, and mapping buses to routes.

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Database Configuration](#database-configuration)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Bus Management System provides the following features:

- User authentication with role-based access (Admin and User).
- Adding, updating, and deleting bus details.
- Mapping buses to predefined routes with start and end times.
- Preventing bus schedule overlaps.
- Displaying route-wise bus details using a stored procedure.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 11 or higher
- Maven (for building the project)
- Git
- Your preferred IDE (e.g., IntelliJ IDEA, Eclipse)

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/surya-kushawah/bus-management-system.git
   cd bus-management-system
# Bus Management System

The Bus Management System is a Spring Boot application designed to help manage a fleet of buses, including user authentication, bus management, and mapping buses to routes.

## Build the Project

To build the project, run the following command:

```bash
./mvnw clean install
```

## Database Configuration

The application uses an H2 in-memory database for simplicity. You can configure other databases in application.properties if needed.
```bash
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
```

## API Documentation
The API documentation is available at http://localhost:8080/swagger-ui.html

# Project Structure

The Bus Management System project follows a standard Spring Boot project structure to enhance maintainability and organization. Here's an overview of the key components:

## 1. Controller

The `controller` package contains API controllers responsible for handling HTTP requests. These controllers define the endpoints and route incoming requests to the appropriate service methods.

## 2. DTO (Data Transfer Objects)

The `dto` package includes Data Transfer Objects. DTOs are used to map data between entities and API requests/responses. They help encapsulate and transfer data between different layers of the application.

## 3. Entity

The `entity` package hosts JPA entities, representing database tables. Each entity class corresponds to a table in the database and defines the structure of the data stored.

## 4. Repository

The `repository` package contains Spring Data JPA repositories. These repositories provide a set of methods for performing database operations, allowing seamless interaction with the underlying database.

## 5. Service

The `service` package encompasses business logic services and their implementations. Services handle the core functionality of the application, such as adding buses, managing routes, and handling user authentication.

## Dependencies

The project relies on the following technologies and dependencies:

- **Java 11**: The programming language used for development.
- **Spring Boot 2.x**: The framework that simplifies the development of Spring applications, providing conventions and defaults.
- **Spring Data JPA**: A part of the Spring Data project, simplifying the implementation of data access with JPA.
- **H2 Database**: Used as an in-memory database for simplicity during development. You can replace it with your preferred database for production.

Feel free to explore and customize the project structure based on your specific requirements and preferences. The modular structure facilitates scalability and ease of maintenance.


