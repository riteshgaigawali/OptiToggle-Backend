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

import com.optitoggle.main.payloads.ApiResponse;
import com.optitoggle.main.payloads.UserDto;
import com.optitoggle.main.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/optitoggle")
public class UserController {

    @Autowired
    private UserService userService;

    // GET (Get all users)
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUser() {

        return ResponseEntity.ok(this.userService.getAllUsers());

    }

    // GET (Get a user by Id)
    @GetMapping("users/{userid}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userid) {
        return ResponseEntity.ok(this.userService.getUserById(userid));

    }

    // POST (Add new user)
    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {

        try {
            return new ResponseEntity<>(this.userService.addUser(userDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT (Update existing user)
    @PutMapping("/users/{userid}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int userid) {
        UserDto updatedUser = this.userService.updateUser(userDto, userid);
        return ResponseEntity.ok(updatedUser);
    }

    // // DELETE (Delete existing user)
    @DeleteMapping("users/{userid}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userid) {
        this.userService.deleteUser(userid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted succesfully", true), HttpStatus.OK);

    }

}
