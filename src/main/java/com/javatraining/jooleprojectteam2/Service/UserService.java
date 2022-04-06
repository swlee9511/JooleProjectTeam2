package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
