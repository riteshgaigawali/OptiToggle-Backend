package com.optitoggle.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optitoggle.main.dao.UserDao;
import com.optitoggle.main.entities.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    // getAllUsers method impl
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> getUserById(int userid) {
        return userDao.findById(userid);
    }

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        userDao.save(user);
        return user;
    }

    @Override
    public void deleteUser(int userid) {
        userDao.deleteById(userid);
    }

}
