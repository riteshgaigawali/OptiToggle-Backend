package com.optitoggle.main.services;

import java.util.List;
import com.optitoggle.main.payloads.UserDto;

public interface UserService {
    // Find implementation of this methods in UserServiceImpl.java file.

    // Register new user.
    UserDto registerNewUser(UserDto userDto);

    // Returns all toggle at once.
    public List<UserDto> getAllUsers();

    // Return toggle with specified id.
    public UserDto getUserById(Integer userid);

    // Add toggle to the database.
    public UserDto addUser(UserDto user);

    // Update toggle.
    public UserDto updateUser(UserDto user, Integer userid);

    // Delete toggle from database.
    public void deleteUser(int userid);
}
