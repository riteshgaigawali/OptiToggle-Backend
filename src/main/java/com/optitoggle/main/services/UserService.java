package com.optitoggle.main.services;

import java.util.List;
import com.optitoggle.main.entities.User;

public interface UserService {
    // Find implementation of this methods in UserServiceImpl.java file.

    // Returns all toggle at once.
    public List<User> getAllUsers();

    // Return toggle with specified id.
    public User getUserById(int userid);

    // Add toggle to the database.
    public User addUser(User user);

    // Update toggle.
    public User updateUser(User user, int userid);

    // Delete toggle from database.
    public void deleteUser(int userid);
}
