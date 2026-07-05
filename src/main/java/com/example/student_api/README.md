[//]: # (# Student Management API)

[//]: # ()
[//]: # (A RESTful API built with Java and Spring Boot to manage student records.)

[//]: # ()
[//]: # (## Tech Stack)

[//]: # (* Java)

[//]: # (* Spring Boot)

[//]: # (* PostgreSQL &#40;Migrated from in-memory HashMap&#41;)

[//]: # ()
[//]: # (## Features)

[//]: # (* Create, Read, Update, and Delete &#40;CRUD&#41; student profiles.)

[//]: # (* Persistent database storage.)

# Student Management REST API

A scalable, enterprise-grade RESTful web service built with **Java** and **Spring Boot**. This project manages student records and demonstrates core backend engineering principles, including a 3-tier architecture, Object-Relational Mapping (ORM), and relational database integration.

## 🚀 Tech Stack
* **Language:** Java
* **Framework:** Spring Boot (Spring Web, Spring Data JPA)
* **Database:** PostgreSQL
* **Build Tool:** Maven
* **Testing:** Postman

## ✨ Core Features
* **Complete CRUD Operations:** Create, Read, Update, and Delete student records via HTTP methods.
* **3-Tier Architecture:** Clean separation of concerns using `Controller`, `Service`, and `Repository` layers.
* **Object-Relational Mapping (ORM):** Uses Hibernate to automatically map Java POJOs (`@Entity`) to PostgreSQL database tables.
* **Custom Database Queries:** Leverages Spring Data JPA to generate SQL dynamically via method signatures (e.g., `findByEmail`).
* **Standardized HTTP Responses:** Uses `ResponseEntity` to return industry-standard status codes (`200 OK`, `404 Not Found`, etc.) alongside JSON payloads.
