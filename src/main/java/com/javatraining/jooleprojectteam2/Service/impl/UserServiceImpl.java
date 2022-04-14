package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Exception.UserAlreadyExistException;
import com.javatraining.jooleprojectteam2.Exception.UserDoesntExistException;
import com.javatraining.jooleprojectteam2.Repository.UserRepository;
import com.javatraining.jooleprojectteam2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User create(User user) throws UserAlreadyExistException{
        if (userRepository.existsById(user.getUserName())) {
            throw new UserAlreadyExistException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public User find(String username) throws UserDoesntExistException{
        Optional<User> tmp = userRepository.findById(username);
        if (!tmp.isPresent()) {
            throw new UserDoesntExistException("User doesn't exist");
        }
        return tmp.get();
    }

    @Override
    public User updateProfile(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String userName) {
        userRepository.deleteById(userName);
    }

    @Override
    public Set<Project> findAllProjectInUser(String username) {
        return userRepository.findById(username).get().getProjectSets();
    }
}
