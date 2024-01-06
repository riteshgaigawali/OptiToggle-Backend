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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optitoggle.main.entities.User;
import com.optitoggle.main.services.UserService;

@RestController
@RequestMapping("/optitoggle")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all user details.
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {

        try {
            return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Get user by id.
    @GetMapping("users/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable int userid) {

        try {
            return new ResponseEntity<>(this.userService.getUserById(userid), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Add user.
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        try {
            return new ResponseEntity<>(this.userService.addUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update user
    @PutMapping("/users/{userid}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int userid) {

        try {
            return new ResponseEntity<>(this.userService.updateUser(user, userid), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
