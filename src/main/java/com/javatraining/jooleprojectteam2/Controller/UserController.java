package com.javatraining.jooleprojectteam2.Controller;

import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            userService.create(user);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findUser(@RequestParam(name = "userName") String userName) {
        User res;
        try {
            res = userService.find(userName);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        userService.updateProfile(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam(name = "userName") String userName) {
        userService.delete(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
