# User Management System

A **Spring Boot REST API** that manages users with **role-based access control (Admin, Manager, User)** and **JWT authentication**.
The system allows administrators to manage users, managers to assign tasks, and users to view their own profiles and tasks.

---

## Tech Stack

* **Java 21**
* **Spring Boot**
* **Spring Security**
* **JWT (JSON Web Token)**
* **Spring Data JPA / Hibernate**
* **MySQL Database**
* **Maven**
* **Lombok**

---

## Features

### Authentication

* JWT-based authentication
* Secure password storage using **BCrypt**
* Login API to generate JWT token

### Role-Based Access Control

The system supports three roles:

| Role        | Permissions                            |
| ----------- | -------------------------------------- |
| **Admin**   | Create, read, update, and delete users |
| **Manager** | Assign tasks to users                  |
| **User**    | View own profile and assigned tasks    |

---

## API Endpoints

### Authentication

| Method | Endpoint      | Description                            |
| ------ | ------------- | -------------------------------------- |
| POST   | `/auth/login` | Authenticate user and return JWT token |

---

### Admin APIs

| Method | Endpoint             | Description     |
| ------ | -------------------- | --------------- |
| GET    | `/admin/users`       | Get all users   |
| POST   | `/admin/create`      | Create new user |
| DELETE | `/admin/delete/{id}` | Delete user     |

---

### Manager APIs

| Method | Endpoint               | Description           |
| ------ | ---------------------- | --------------------- |
| POST   | `/manager/assign-task` | Assign task to a user |

---

### User APIs

| Method | Endpoint     | Description      |
| ------ | ------------ | ---------------- |
| GET    | `/user/{id}` | Get user profile |

---

## Database

MySQL is used as the relational database.

Example configuration in **application.properties**:

```
spring.datasource.url=jdbc:mysql://localhost:3306/usermanagement
spring.datasource.username=root
spring.datasource.password=yourpassword
```

Hibernate automatically creates the following tables:

* users
* role
* task
* user_roles

---

## Project Structure

```
src
 ├── config
 ├── controller
 ├── dto
 ├── entity
 ├── exception
 ├── repository
 ├── security
 ├── service
 └── resources
```

---

## How to Run the Project

1. Clone the repository

```
git clone https://github.com/NikitaKhupse/user-management-system.git
```

2. Navigate to the project folder

```
cd user-management-system
```

3. Configure MySQL in `application.properties`.

4. Run the application

```
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## Author

**Nikita Khupse**

Java Full Stack Developer
GitHub: https://github.com/NikitaKhupse
