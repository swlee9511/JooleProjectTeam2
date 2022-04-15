package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.Role;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserRepository userRepository;
    @Test
    void create() {
        userRepository.deleteById("ForService");
        User user = new User("ForService",Role.ADMIN,"123456");
        userServiceImpl.create(user);
        Assertions.assertEquals(user.getUserName(), userRepository.findById("ForService").get().getUserName());
    }

    @Test
    void find() {
        User user = new User("ForService",Role.ADMIN,"123456");
        userServiceImpl.create(user);
        Assertions.assertEquals(userServiceImpl.find("ForService").getUserName(), "ForService");
    }

    @Test
    void updateProfile() {
        User user = new User("ForService", Role.USER,"6666666666");
        userServiceImpl.updateProfile(user);
        Assertions.assertNotEquals(userRepository.findById("ForService").get().getRole(), "owner");
    }

    @Test
    void delete() {
        userServiceImpl.delete("ForService");
        Assertions.assertFalse(userRepository.findById("ForService").isPresent());
    }
}