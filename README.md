# Feature Toggle Management Microservice

This project is a feature toggle management microservice built with Java 11 and Spring Boot. It provides a RESTful API for managing feature toggles, also known as feature flags, within an application.

## Technologies Used

- Java 11
- Spring Boot
- MySQL 8

## Features

- User management:
  - Register new users
  - Retrieve user information
  - Update user details
  - Delete users
- Toggle management:
  - Create new feature toggles
  - Retrieve existing toggles
  - Update toggle configurations
  - Delete toggles

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/feature-toggle-management.git
   cd feature-toggle-management
   ```

2. **Database Configuration:**
   - Install MySQL 8 and create a new database.
   - Update `application.properties` with your database configuration.

3. **Build and Run:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Accessing the API:**
   The API will be available at `http://localhost:8080`.

## API Documentation

- Swagger documentation has been integrated for easy API exploration.
- Access the documentation at `http://localhost:8080/swagger-ui/index.html`.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.
