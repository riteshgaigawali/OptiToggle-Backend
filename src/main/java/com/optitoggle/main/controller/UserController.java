package com.optitoggle.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.optitoggle.main.entities.User;
import com.optitoggle.main.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Get all user details.
    @GetMapping("/users")
    public List<User> getAllUser() {

        return this.userService.getAllUsers();

    }

    // Get user by id.
    @GetMapping("users/{userid}")
    public User getUserById(@PathVariable int userid) {

        return this.userService.getUserById(userid);
    }

    // Add user.
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {

        return this.userService.addUser(user);
    }

    // Update user
    @PutMapping("/users/{userid}")
    public User updateUser(@RequestBody User user, @PathVariable int userid) {

        return this.userService.updateUser(user, userid);
    }

    // // Delete user
    @DeleteMapping("users/{userid}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int userid) {
        try {
            this.userService.deleteUser(userid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
