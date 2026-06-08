# ProjectManagerAPI

## Overview

ProjectManagerAPI is a Spring Boot REST API for managing projects. It provides CRUD operations along with DTO mapping, validation, exception handling, and PostgreSQL database integration.

## Features

* Create a Project
* Get All Projects
* Get Project by ID
* Update Project
* Delete Project
* DTO Layer Implementation
* Request Validation
* Global Exception Handling
* PostgreSQL Database Integration
* RESTful API Design

## Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Hibernate Validator

## Project Structure

```text
src/main/java/com/day11project2/ProjectManagerAPI
│
├── controller
│   └── ProjectController.java
│
├── dto
│   ├── ProjectRequestDto.java
│   └── ProjectResponseDto.java
│
├── entity
│   └── Project.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
│
├── repository
│   └── ProjectRepository.java
│
├── service
│   └── ProjectService.java
│
└── ProjectManagerApiApplication.java
```

## Database Configuration

### Create Database

```sql
CREATE DATABASE project_manager_db;
```

### Connect to Database

```sql
\c project_manager_db
```

### Create Table

```sql
CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    start_date DATE,
    end_date DATE
);
```

### Sample Data

```sql
INSERT INTO projects (name, description, start_date, end_date)
VALUES
('Bug Tracking System', 'Application for tracking software bugs', '2026-01-10', '2026-12-31'),
('Employee Management', 'Manage employee records and attendance', '2026-02-01', '2026-11-30'),
('Online Shopping Portal', 'E-commerce website for online purchases', '2026-03-15', '2026-10-15');
```

## API Endpoints

### Get All Projects

```http
GET /projects
```

### Get Project By ID

```http
GET /projects/{id}
```

### Create Project

```http
POST /projects
```

Request Body:

```json
{
  "name": "Hospital Management",
  "description": "Manage hospital operations",
  "startDate": "2026-06-01",
  "endDate": "2026-12-31"
}
```

### Update Project

```http
PUT /projects/{id}
```

### Delete Project

```http
DELETE /projects/{id}
```

## Validation Rules

* Project name cannot be blank.
* Description cannot be blank.
* Start date must be past or present.
* End date must be a future date.

## HTTP Status Codes

| Status Code | Description           |
| ----------- | --------------------- |
| 200         | Success               |
| 201         | Created               |
| 204         | No Content            |
| 400         | Bad Request           |
| 404         | Not Found             |
| 500         | Internal Server Error |

## Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

## Learning Outcomes

* Spring Boot REST APIs
* Service Layer Architecture
* DTO Mapping
* Validation using Jakarta Validation
* Exception Handling
* PostgreSQL Integration
* CRUD Operations with Spring Data JPA

```
```
