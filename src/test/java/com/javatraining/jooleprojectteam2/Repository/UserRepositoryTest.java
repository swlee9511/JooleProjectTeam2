package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.Role;
import com.javatraining.jooleprojectteam2.Entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest() {
        User user = new User("AAA", Role.USER,"123456");
        User res = userRepository.save(user);
        Assertions.assertNotEquals(null, res);
    }
    @Test
    public void findIdTest() {
        User user = new User("AAA",Role.ADMIN,"123456");
        User tmp = userRepository.save(user);

        Optional<User> res = userRepository.findById(tmp.getUserName());
        Assertions.assertNotEquals(null, res.get());
    }

}