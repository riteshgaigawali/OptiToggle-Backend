package com.optitoggle.main.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.optitoggle.main.dao.RoleDao;
import com.optitoggle.main.dao.UserDao;
import com.optitoggle.main.entities.Roles;
import com.optitoggle.main.entities.User;
import com.optitoggle.main.exceptions.ResourceNotFoundException;
import com.optitoggle.main.payloads.UserDto;
import com.optitoggle.main.payloads.UserDtoResponse;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleDao roleDao;

    // getAllUsers() method implementation
    @Override
    public List<UserDtoResponse> getAllUsers() {
        List<User> users = this.userDao.findAll();
        List<UserDtoResponse> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    // getUserById() method implementation
    @Override
    public UserDtoResponse getUserById(Integer userid) {
        User user = this.userDao.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userid", userid));
        return this.userToDto(user);

    }

    // addUser() method implementation
    @Override
    public UserDtoResponse addUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setCreatedOn(new Date());
        Roles role = this.roleDao.findById(202).get();
        user.getRoles().add(role);
        User newUser = this.userDao.save(user);

        return this.modelMapper.map(newUser, UserDtoResponse.class);
    }

    // updateUser() method implementation
    @Override
    public UserDtoResponse updateUser(UserDto userDto, Integer userid) {
        User user = this.userDao.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userid", userid));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmailid(userDto.getEmailid());
        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        User updatedUser = this.userDao.save(user);
        UserDtoResponse userDtoResponse = this.userToDto(updatedUser);
        return userDtoResponse;
    }

    // deleteUser() method implementation

    @Override
    public void deleteUser(int userid) {
        User user = this.userDao.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userid", userid));
        user.getRoles().clear();
        this.userDao.delete(user);
    }

    public User dtoToUser(UserDtoResponse userDtoResponse) {
        User user = this.modelMapper.map(userDtoResponse, User.class);
        return user;
    }

    public UserDtoResponse userToDto(User user) {
        UserDtoResponse userDtoResponse = this.modelMapper.map(user, UserDtoResponse.class);
        return userDtoResponse;
    }

    @Override
    public UserDtoResponse registerNewUser(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Roles role = this.roleDao.findById(201).get();
        user.getRoles().add(role);
        user.setCreatedOn(new Date());
        User newUser = this.userDao.save(user);
        return this.modelMapper.map(newUser, UserDtoResponse.class);
    }

}
