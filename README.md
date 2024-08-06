
# OptiToggle Backend

The OptiToggle Backend is a RESTful API for managing feature toggles and user information. This API provides endpoints to handle authentication, user management, and feature toggle operations. It is built using Java Spring Boot and interacts with a MySQL database.

## Technologies Used

- Java 17
- Spring Boot
- MySQL 8

## Features

- **User Management:**
  - Register new users
  - Retrieve user information
  - Update user details
  - Delete users

- **Toggle Management:**
  - Create new feature toggles
  - Retrieve existing toggles
  - Update toggle configurations
  - Delete toggles

## Database Schema

The database schema for the OptiToggle backend is as follows:
-
- ![01 Database](https://github.com/user-attachments/assets/d2a40fe7-3d3e-46d6-b43e-55214bd6d883)
-
- ![02 Tables](https://github.com/user-attachments/assets/e8a5385e-5745-4fdc-8919-34480767eb06)
-
- ![03 Columns](https://github.com/user-attachments/assets/cf8a25b1-4eb8-4677-acfa-fdd998e9ff9b)
-
- ![04 Indexes](https://github.com/user-attachments/assets/80132a34-3a77-4575-9c0e-4f730e895cac)


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

---

Feel free to customize any parts as needed!
