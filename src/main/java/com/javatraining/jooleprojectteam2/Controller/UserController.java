package com.javatraining.jooleprojectteam2.Controller;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.Role;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Service.ProjectService;
import com.javatraining.jooleprojectteam2.Service.UserService;
import com.javatraining.jooleprojectteam2.Service.impl.MyUserDetailsServiceImpl;
import com.javatraining.jooleprojectteam2.Util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager myauthenticaitonManager;

    @Autowired
    private MyUserDetailsServiceImpl userDetailsService;

    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(@RequestBody User user) {
//        if (userService.findByUsername(user.getUsername()) != null) {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
        user.setRole(Role.OWNER);
        try {
            userService.create(user);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestParam(name="username") String username, @RequestParam(name="password") String password)  throws Exception {
        Authentication authentication;
        try {
            authentication = myauthenticaitonManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)//User.getUsername(), User.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = (UserDetails)authentication.getPrincipal();

//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(username);//User.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return  new ResponseEntity<>(jwt, HttpStatus.OK);
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
