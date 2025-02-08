# Recruiting System

A web-based Recruiting System for managing job applications, tracking applicants, and streamlining the hiring process.

## Features
- 📝 Apply for a Position – Candidates can submit applications with skills and availability.
- 📋 List Applications – Recruiters can view and filter candidate applications.
- ⚡ REST API – Supports GET/POST operations for managing applications.
- 🛠 Built with Spring Boot, PostgreSQL, and Vue.js.

## Technologies used
**Backend**: Java (Spring Boot)
**Frontend:**  Vue.js
**Database:** PostgreSQL
**Containerization:** Docker & Docker Compose

## Installation
**1. Clone the repository**
git clone https://github.com/Diddi25/Recruiting-system.git

**2. Start the application (Docker)**
docker-compose up --build

**3. API Endpoints**
* Apply for a position:
POST http://localhost:8080/api/applications

* List All Applications (GET):
GET http://localhost:8080/api/applications

# License
This project is licensed under the MIT License.
