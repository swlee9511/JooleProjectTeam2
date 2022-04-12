package com.javatraining.jooleprojectteam2.Controller;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Service.ProjectService;
import com.javatraining.jooleprojectteam2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;

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
    public ResponseEntity<?> findUser(@RequestParam(required = false, name = "userName") String userName) {
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
        try {
            userService.updateProfile(user);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam(required = false, name = "userName") String userName) {
        userService.delete(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAllProject")
    public ResponseEntity<?> findAllProject(@RequestParam(required = false, name = "userName") String userName) {
        Set<Project> tmp;
        try {
             tmp = userService.findAllProjectInUser(userName);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tmp,HttpStatus.OK);
    }

    @PutMapping("/addProject")
    public ResponseEntity<?> addProject(@RequestParam(required = false, name = "userName") String userName, @RequestParam(required = false, name = "projectId") int projectId) {
        try {
            User u = userService.find(userName);
            Project p = projectService.findOne(projectId);
            Set<Project> projects = u.getProjectSets();
            projects.add(p);
            u.setProjectSets(projects);
            p.setUser(u);
            userService.updateProfile(u);
            projectService.update(p);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
