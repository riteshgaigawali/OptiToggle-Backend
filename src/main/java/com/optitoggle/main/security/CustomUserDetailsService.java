package com.optitoggle.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.optitoggle.main.dao.UserDao;
import com.optitoggle.main.entities.User;
import com.optitoggle.main.exceptions.ResourceNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Loading user from database with username
        User user = this.userDao.findByEmailid(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "emailid" + username, 0));

        return user;
    }

}
