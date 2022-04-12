package com.javatraining.jooleprojectteam2.Controller;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/project")
public class ProjectController {

        @Autowired
        ProjectService projectService;

        // PostmanURL: localhost:8080/project/create
        @PostMapping("/create")
        public ResponseEntity<?> createProject(@RequestBody Project project) {
                try {
                        projectService.create(project);
                } catch(Exception e) {
                        return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
                }
                return new ResponseEntity<>(HttpStatus.CREATED);
        }
        // PostmanURL: localhost:8080/project/find?projectId=X
        @GetMapping("/find")
        public ResponseEntity<?> findProject(@RequestParam(required = false, name = "projectId") int projectId) {
                Project res;
                try {
                        res = projectService.findOne(projectId);
                } catch(Exception e) {
                        return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
                }
                return new ResponseEntity<>(res, HttpStatus.CREATED);

        }
        // PostmanURL: localhost:8080/project/updateProject?projectId=X
        @PutMapping("/updateProject")
        public ResponseEntity<?> updateProject(@RequestBody Project project, @RequestParam(required = false, name="projectId") int projectId) {
                Project temp;
                try {
                        temp = projectService.findOne(projectId);
                        temp.setUser(project.getUser());
                        temp.setProductSet(project.getProductSet());
                        //temp.setLastUpdated(new Date());
                        projectService.update(temp);
                } catch(Exception e) {
                        return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
                }
                return new ResponseEntity<>(temp, HttpStatus.CREATED);
        }
        // PostmanURL: localhost:8080/project/deleteProject?projectId=X
        @DeleteMapping("/deleteProject")
        public ResponseEntity<?> deleteProject(@RequestParam(required = false, name="projectId") int projectId) {
                projectService.delete(projectId);
                return new ResponseEntity<>(HttpStatus.OK);
        }
}
