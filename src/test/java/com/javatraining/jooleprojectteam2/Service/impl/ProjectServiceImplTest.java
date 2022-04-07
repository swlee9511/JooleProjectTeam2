package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    ProjectServiceImpl projectServiceImpl;
    @Autowired
    ProjectRepository projectRepository;

    private Project project;

    @BeforeEach
    public void setup() {
        this.project = new Project();
        project.setLastUpdated(new Date());
        project.setTimeCreated(new Date());
    }

    @Test
    void create() {
        Project p = projectServiceImpl.create(project);
        Assertions.assertTrue(projectRepository.findById(p.getProjectId()).isPresent());
    }

    @Test
    void findOne() {
        Project p = projectServiceImpl.create(project);
        Project p2 = projectServiceImpl.findOne(p.getProjectId());
        Assertions.assertEquals(p.getProjectId(), p2.getProjectId());

    }

    @Test
    void update() {
        Project p = projectServiceImpl.create(project);
        Date tmp = p.getLastUpdated();
        p.setLastUpdated(new Date());
        Project p2 = projectServiceImpl.update(p);
        Assertions.assertNotEquals(tmp, p2.getLastUpdated());
    }

    @Test
    void delete() {
        Project p = projectServiceImpl.create(project);
        int id = p.getProjectId();
        projectServiceImpl.delete(p.getProjectId());
        Assertions.assertFalse(projectRepository.findById(id).isPresent());
    }
}