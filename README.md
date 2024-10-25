# Library Management System

A Library Management System built using Spring Boot that enables librarians to manage books, patrons, and borrowing records efficiently. This API-driven application supports common library operations, including book management, patron management, and borrowing tracking.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Configuration](#configuration)
- [Testing](#testing)
- [Future Enhancements](#future-enhancements)
- [License](#license)

---

## Features

- **Book Management**: CRUD operations for managing books (add, update, retrieve, delete).
- **Patron Management**: CRUD operations for managing patrons (add, update, retrieve, delete).
- **Borrowing Records**: Track when a book is borrowed and returned by a patron.
- **Security**: Basic authentication to protect the API endpoints.
- **Caching**: Cache frequently accessed data to improve performance.
- **Transaction Management**: Ensures data consistency during critical operations.
- **Error Handling**: Global exception handling for meaningful error messages.

## Project Structure

```
library-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.library/
│   │   │       ├── LibraryManagementSystemApplication.java
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       ├── dto/
│   │   │       └── exception/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── schema.sql
│   │       └── data.sql
├── pom.xml
└── README.md
```

### Key Components

- **`LibraryManagementSystemApplication.java`**: Main entry point of the application.
- **Config**: Configuration files for security, caching, and AOP.
- **Controllers**: REST endpoints for book, patron, and borrowing record management.
- **Entities**: Book, Patron, and BorrowingRecord JPA entities.
- **Repositories**: Interfaces for data access.
- **Services**: Business logic for managing books, patrons, and borrowing records.
- **DTOs**: Data Transfer Objects for transferring data between client and server.
- **Exception Handling**: Custom exception handling for better error responses.

## Technologies Used

- **Java**: Primary language
- **Spring Boot**: Application framework
- **Spring Data JPA**: Data access
- **Spring Security**: Basic authentication
- **H2/MySQL**: Database (H2 for in-memory; MySQL for production)
- **JUnit, Mockito**: Testing

## Getting Started

### Prerequisites

- Java JDK 11 or higher
- Maven 3.6+
- MySQL or another relational database

### Installation

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/your-username/library-management-system.git
    cd library-management-system
    ```

2. **Configure the Database**:
    - In `src/main/resources/application.properties`, configure your database connection:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/library_db
        spring.datasource.username=your_db_username
        spring.datasource.password=your_db_password
        ```

3. **Build the Project**:
    ```bash
    mvn clean install
    ```

4. **Run the Application**:
    ```bash
    mvn spring-boot:run
    ```

The application will start on `http://localhost:8080`.

## API Documentation

The following endpoints are available in this application:

### Book Endpoints

- `GET /api/books` - Retrieve a list of all books.
- `GET /api/books/{id}` - Retrieve details of a specific book by ID.
- `POST /api/books` - Add a new book to the library.
- `PUT /api/books/{id}` - Update an existing book's information.
- `DELETE /api/books/{id}` - Remove a book from the library.

### Patron Endpoints

- `GET /api/patrons` - Retrieve a list of all patrons.
- `GET /api/patrons/{id}` - Retrieve details of a specific patron by ID.
- `POST /api/patrons` - Add a new patron.
- `PUT /api/patrons/{id}` - Update an existing patron's information.
- `DELETE /api/patrons/{id}` - Remove a patron from the system.

### Borrowing Endpoints

- `POST /api/borrow/{bookId}/patron/{patronId}` - Allow a patron to borrow a book.
- `PUT /api/return/{bookId}/patron/{patronId}` - Record the return of a borrowed book by a patron.

## Configuration

### application.properties

The `application.properties` file contains the main configurations for the application. Here is an example:

```properties
# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=password

# Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Caching configuration
spring.cache.type=simple

# Security (default credentials for testing)
spring.security.user.name=admin
spring.security.user.password=admin
```

### Optional Configurations

- **Security**: Basic authentication with default credentials (can be customized).
- **Caching**: Use Spring's caching mechanisms to cache book and patron details.
- **Transaction Management**: Ensure data consistency by using `@Transactional`.

## Testing

Unit tests are implemented for service and controller layers using JUnit and Mockito. To run the tests, execute:

```bash
mvn test
```

### Example Tests

- `BookServiceTests`: Tests for book service methods.
- `BookControllerTests`: Tests for book controller endpoints.

## Future Enhancements

- **Advanced Security**: Implement JWT-based authentication.
- **Asynchronous Processing**: Use asynchronous processing for long-running tasks.
- **Frontend Integration**: Develop a frontend application for user interaction.
- **Enhanced Caching**: Implement Redis or Ehcache for distributed caching.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to explore, modify, and distribute the codebase. For any questions or feedback, please contact us at [Mahmoud Eid](mailto:eng.mahmod.eid.elsayed@gmail.com).
