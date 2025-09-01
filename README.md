# Library Management System (Spring Boot + Spring Security)

A simple Library Management System built using Spring Boot and Spring Security demonstrating basic authentication and role-based authorization with in-memory user management.
The application includes public pages, role-specific access to book management, reservations, and admin reports. Custom login and access denied pages are implemented with Thymeleaf templates and basic styling.

## How to Run
- Import as Maven project
- Run `LibraryApplication.java`
- Access: http://localhost:8080

## Credentials

| Username  | Password    | Role      |
|-----------|-------------|-----------|
| admin     | admin123    | ADMIN     |
| lib123    | lib123      | LIBRARIAN |
| student   | student123  | STUDENT   |
| guest     | guest123    | GUEST     |

## Endpoints Overview

### Public
- `/` - Home
- `/about` - About
- `/login` - Login
- `/books/public` - Public book list

### Student
- `/books`
- `/books/{id}`
- `/books/{id}/reserve`

### Librarian
- All student endpoints +
- `/books` [POST]
- `/books/{id}` [PUT]
- `/reservations`
- `/reservations/{id}/approve`

### Admin
- All librarian endpoints +
- `/books/{id}` [DELETE]
- `/users`
- `/admin/reports`

## Screenshots

<img width="2940" height="1912" alt="image" src="https://github.com/user-attachments/assets/e532cc43-df4e-45e2-be6b-7761c591dad3" />

<img width="2940" height="1912" alt="image" src="https://github.com/user-attachments/assets/f5ab99b6-5441-4169-90af-68d04601b349" />
<img width="2940" height="1912" alt="image" src="https://github.com/user-attachments/assets/eca88333-00e6-411a-a0e6-4054db08b05b" />


## Test Results
<img width="2940" height="1912" alt="image" src="https://github.com/user-attachments/assets/031236df-b998-450a-8730-632c3838f07c" />

