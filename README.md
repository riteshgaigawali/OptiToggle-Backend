Here’s the updated `README.md` file with the database schema included:

---

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

```sql
CREATE DATABASE ffsvc;
USE ffsvc;

CREATE TABLE `users` (
  `userid` INT AUTO_INCREMENT PRIMARY KEY,
  `fname` VARCHAR(255) NOT NULL,
  `lname` VARCHAR(255) NOT NULL,
  `emailid` VARCHAR(255) UNIQUE NOT NULL,
  `pswd` VARCHAR(255) NOT NULL,
  `createdOn` DATETIME
);

CREATE TABLE `roles` (
  `roleid` INT AUTO_INCREMENT PRIMARY KEY,
  `rolename` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `isDeleted` BOOLEAN
);

CREATE TABLE `user_roles` (
  `roleid` INT NOT NULL,
  `userid` INT NOT NULL,
  PRIMARY KEY (`roleid`, `userid`)
);

CREATE TABLE `feature_flags` (
  `flagid` INT AUTO_INCREMENT PRIMARY KEY,
  `key` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT,
  `enabled` BOOLEAN NOT NULL,
  `createdBy` INT NOT NULL,
  `createdOn` DATETIME
);

CREATE TABLE `evaluation_history` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `flagid` INT NOT NULL,
  `modifiedBy` INT NOT NULL,
  `modifiedOn` DATETIME,
  `oldvalue` BOOLEAN,
  `newvalue` BOOLEAN
);

CREATE TABLE `api_keys` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `apikey` VARCHAR(255) UNIQUE NOT NULL,
  `createdBy` INT NOT NULL,
  `createdOn` DATETIME,
  `expiresOn` DATETIME,
  `isDeleted` BOOLEAN
);

CREATE TABLE `access_logs` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `apikey` VARCHAR(255) NOT NULL,
  `flagid` INT NOT NULL,
  `accessedOn` DATETIME,
  `evaluation` BOOLEAN,
  `accessedByIP` VARCHAR(255) NOT NULL
);

ALTER TABLE `user_roles` ADD FOREIGN KEY (`userid`) REFERENCES `users` (`userid`);
ALTER TABLE `user_roles` ADD FOREIGN KEY (`roleid`) REFERENCES `roles` (`roleid`);
ALTER TABLE `feature_flags` ADD FOREIGN KEY (`createdBy`) REFERENCES `users` (`userid`);
ALTER TABLE `evaluation_history` ADD FOREIGN KEY (`flagid`) REFERENCES `feature_flags` (`flagid`);
ALTER TABLE `evaluation_history` ADD FOREIGN KEY (`modifiedBy`) REFERENCES `users` (`userid`);
ALTER TABLE `access_logs` ADD FOREIGN KEY (`apikey`) REFERENCES `api_keys` (`apikey`);
ALTER TABLE `api_keys` ADD FOREIGN KEY (`createdBy`) REFERENCES `users` (`userid`);
ALTER TABLE `access_logs` ADD FOREIGN KEY (`flagid`) REFERENCES `feature_flags` (`flagid`);
```

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
