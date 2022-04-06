package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Exception.UserAlreadyExistException;
import com.javatraining.jooleprojectteam2.Repository.UserRepository;
import com.javatraining.jooleprojectteam2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    //private PasswordEncoder passwordEncoder;//for Spring security later

    @Override
    public User create(User user) throws UserAlreadyExistException{
        if (userRepository.existsById(user.getUserName())) {
            throw new UserAlreadyExistException("User already exists");
        }
        user.setPassword(user.getPassword());// change here after enable Spring security
        userRepository.save(user);
        return user;
    }

    @Override
    public User find(String username) {

        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }
}
