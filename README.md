# Employee Management System - REST API

![Java](https://img.shields.io/badge/Java-21-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen) ![MySQL](https://img.shields.io/badge/MySQL-8.0-blue) ![Maven](https://img.shields.io/badge/Maven-3.9-red)

A production-ready Spring Boot REST API for managing employee data with comprehensive validation, exception handling, structured logging, and Swagger documentation.

> **Note**: This is an enhanced version of my earlier [Employee Management Desktop Application](https://github.com/adityaff10/employee-management-desktop), evolved from a Java Swing + JDBC application to a modern REST API following industry best practices.

## 🔄 Project Evolution

This project represents a significant upgrade from the original desktop application:

| Feature | Desktop Version (v1) | REST API Version (v2) |
|---------|---------------------|---------------------|
| **Architecture** | Monolithic Desktop (Swing) | Layered REST API |
| **Database Access** | JDBC with DAO Pattern | Spring Data JPA |
| **UI** | Java Swing (JFrame, JTable) | API-first (Swagger UI) |
| **Validation** | Manual validation | Jakarta Bean Validation |
| **Error Handling** | Try-catch blocks | Global Exception Handler |
| **Logging** | System.out.println | SLF4J + Logback |
| **Documentation** | None | Auto-generated Swagger |
| **Design Pattern** | DAO Pattern | DTO + Service + Repository |
| **Deployment** | Desktop executable | Web server / Cloud-ready |