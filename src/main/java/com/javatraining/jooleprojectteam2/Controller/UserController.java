package com.javatraining.jooleprojectteam2.Controller;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.Role;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Service.MyUserDetailService;
import com.javatraining.jooleprojectteam2.Service.ProjectService;
import com.javatraining.jooleprojectteam2.Service.UserService;
import com.javatraining.jooleprojectteam2.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailService myUserDetailService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestParam(name="userName") String userName,
                                                       @RequestParam(name="password") String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = myUserDetailService.loadUserByUsername(userName);
        final String jwt = jwtUtil.generateToken(userDetails);
        return  new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        //user.setRole(Role.USER);
        try {
            userService.create(user);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
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

    @PutMapping("/admin/update")
    public ResponseEntity<?> updateUser(@RequestBody User user,
                                        @RequestParam(required = false, name="userName") String userName) {
        User temp;
        try {
            temp = userService.findByUsername(userName);
            temp.setRole(user.getRole());
            temp.setPassword(user.getPassword());
            userService.updateProfile(temp);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete")
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
    public ResponseEntity<?> addProject(@RequestParam(required = false, name = "userName") String userName,
                                        @RequestParam(required = false, name = "projectId") int projectId) {
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
