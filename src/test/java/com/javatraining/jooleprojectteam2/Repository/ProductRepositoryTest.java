package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    ProjectRepository projectRepository;
    @Test
    public void saveTest(){
        Project project = new Project();
        project.setTimeCreated(new Date());
        project.setLastUpdated(new Date());
        Project res = projectRepository.save(project);
        Assertions.assertNotEquals(null, res);
    }
    @Test
    public void findByIdTest() {
        Project project = new Project();
        project.setTimeCreated(new Date());
        project.setLastUpdated(new Date());
        Project tmp = projectRepository.save(project);
        Optional<Project> res = projectRepository.findById(tmp.getProject_id());
        Assertions.assertNotEquals(null, res.get());
    }
}