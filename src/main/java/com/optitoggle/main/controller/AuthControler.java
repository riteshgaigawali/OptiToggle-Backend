package com.optitoggle.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optitoggle.main.exceptions.ApiException;
import com.optitoggle.main.payloads.JwtAuthRequest;
import com.optitoggle.main.payloads.JwtAuthResponse;
import com.optitoggle.main.payloads.UserDto;
import com.optitoggle.main.payloads.UserDtoResponse;
import com.optitoggle.main.security.JwtTokenHelper;
import com.optitoggle.main.services.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/auth/")
@Api(tags = "Authentication APIs")
public class AuthControler {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {

        this.authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken(token);
        return new ResponseEntity<JwtAuthResponse>(jwtAuthResponse, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);

        try {
            this.authenticationManager.authenticate(authenticationToken);
            System.out.println("User authenticated successfully !!!!!!");
        } catch (BadCredentialsException e) {
            System.out.println("Invalid Credentials !!");
            throw new ApiException("Invalid username or password !!");
        }

    }

    // register new user endpoint
    @PostMapping("/register")
    public ResponseEntity<UserDtoResponse> registerNewUser(@Valid @RequestBody UserDto userDto) {
        UserDtoResponse registeredUser = this.userService.registerNewUser(userDto);
        return new ResponseEntity<UserDtoResponse>(registeredUser, HttpStatus.CREATED);
    }
}
