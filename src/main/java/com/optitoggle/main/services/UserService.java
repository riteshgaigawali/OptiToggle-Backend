package com.optitoggle.main.services;

import java.util.List;

import com.optitoggle.main.payloads.UserDto;
import com.optitoggle.main.payloads.UserDtoResponse;

public interface UserService {
    // Find implementation of this methods in UserServiceImpl.java file.

    // Register new user.
    UserDtoResponse registerNewUser(UserDto userDto);

    // Returns all user at once.
    public List<UserDtoResponse> getAllUsers();

    // Return user with specified id.
    public UserDtoResponse getUserById(Integer userid);

    // Add user to the database.
    public UserDtoResponse addUser(UserDto userDto);

    // Update user.
    public UserDtoResponse updateUser(UserDto userDto, Integer userid);

    // Delete user from database.
    public void deleteUser(int userid);
}
