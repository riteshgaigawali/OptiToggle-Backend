# OptiToggle Backend

The OptiToggle Backend is a RESTful API for managing feature toggles and user information. This API provides endpoints to handle authentication, user management, and feature toggle operations. It is built using Java Spring Boot and interacts with a MySQL database.

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

## Setup and Installation

### Prerequisites

- Java 17
- Maven
- MySQL Server
  
1. **Clone the repository:**
   ```bash
   git clone https://github.com/riteshgaigawali/OptiToggle.git
   cd OptiToggle
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

## API Endpoints

**Authentication**
- POST /api/v1/auth/register - Register a new user.
- POST /api/v1/auth/login - Authenticate a user and return a JWT token.
  
**Users**
- GET /optitoggle/users - Get a list of all users.
- POST /optitoggle/users - Create a new user.
- PUT /optitoggle/users/{id} - Update an existing user.
- DELETE /optitoggle/users/{id} - Delete a user by ID.
  
**Feature Toggles**
- GET /optitoggle/toggle - Get a list of all feature toggles.
- POST /optitoggle/user/{userId}/toggle - Create a new feature toggle for a user.
- PUT /optitoggle/toggle/{flagId} - Update an existing feature toggle.
- DELETE /optitoggle/toggle/{flagId} - Delete a feature toggle by ID.

## Testing
For API testing, you can use tools like Postman or cURL to make requests to the endpoints. Ensure that the server is running before performing tests.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

## Contact
For any questions or issues, please reach out to riteshgaigawali2001@gmail.com
