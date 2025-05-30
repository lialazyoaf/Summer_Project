# Wk#1 hw - fullstack app - mynotes

A simple full‑stack note‑taking application built 
with Spring Boot, MongoDB, and React.

##  Directory Structure

mynotes-app/
├── backend/ # Spring Boot + MongoDB
├── frontend/ # React SPA
└── README.md

## Prerequisites
- Java 17
- Node.js & npm
- MongoDB (local or Atlas)

## Quick start

1. **Backend**
```bash
cd backend
./mvnw spring-boot:run
```
Runs on http://localhost:8080

2. **Frontend**
```bash
cd frontend
npm install
npm start
```

## API

- `GET /api/notes`
    
- `GET /api/notes/{id}`
    
- `POST /api/notes`
    
- `PUT /api/notes/{id}`
    
- `DELETE /api/notes/{id}`
    
