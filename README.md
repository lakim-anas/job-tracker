# Job Application Tracker API

A back-end REST API for tracking job and internship applications, built with Java and Spring Boot. I'm building this project step by step to learn back-end development.

**Status:** In progress

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA / Hibernate
- H2 in-memory database
- Maven
- Git and GitHub

## Features
- [x] Spring Boot project setup with Maven
- [x] JobApplication entity (company, role, status, date applied)
- [x] Repository that saves and reads applications from the H2 database
- [x] GET /applications endpoint that returns all applications as JSON
- [x] POST /applications endpoint to add a new application
- [x] GET /applications/{id} to get one application
- [x] DELETE /applications/{id} to remove an application
- [x] PUT /applications/{id} to update an application (full CRUD complete)
- [x] Error handling with proper HTTP status codes (200, 201, 204, 404)
- [ ] Input validation
- [ ] Unit tests with JUnit
- [ ] Switch to a MySQL database

## How to Run
1. Clone the repo: `git clone https://github.com/lakim-anas/job-tracker.git`
2. Open the folder and run: `mvnw spring-boot:run`
3. The app starts at `http://localhost:8080`

## What I'm Learning
How Spring Boot apps are structured, how JPA maps Java classes to database tables, and how to build and test a REST API.