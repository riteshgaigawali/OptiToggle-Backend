package com.optitoggle.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optitoggle.main.dao.UserDao;
import com.optitoggle.main.entities.User;
import com.optitoggle.main.exceptions.ResourceNotFoundEexception;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    // getAllUsers method impl
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    // getUserById method impl
    @Override
    public User getUserById(int userid) {
        return userDao.findById(userid).orElseThrow(() -> (new ResourceNotFoundEexception("User", "userid", userid)));
    }

    // addUser method impl
    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    // updateUser method impl
    @Override
    public User updateUser(User user, int userid) {
        User updatedUser = userDao.findById(userid)
                .orElseThrow(() -> (new ResourceNotFoundEexception("User", "userid", userid)));
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmailid(user.getEmailid());
        updatedUser.setPassword(user.getPassword());
        userDao.save(updatedUser);
        return updatedUser;
    }

    // deleteUser mehtod impl
    @Override
    public void deleteUser(int userid) {
        userDao.deleteById(userid);
    }

}
