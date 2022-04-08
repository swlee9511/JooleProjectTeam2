package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.*;
import com.javatraining.jooleprojectteam2.Repository.ProjectProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectProductServiceImplTest {
    @Autowired
    ProjectProductServiceImpl projectProductServiceImpl;
    @Autowired
    ProjectProductRepository projectProductRepository;

    private ProjectProduct projectProduct;
    @BeforeEach

        public void setup() {
            this.projectProduct = new ProjectProduct();

    //        this.projectProduct= new ProjectProduct();
//        projectProduct.setTimeCreated(new Date());
////        Product product = new Product();
////        product.setBrand("dell");
////        Project project = new Project();
////        project.setTimeCreated(new Date());
////        project.setTimeCreated(new Date());
////        pp.setProduct(product);
////        pp.setProject(project);
    }
    @Test
    void create() {
        ProjectProduct pp1 = projectProductServiceImpl.create(projectProduct);

        Assertions.assertNotNull(projectProductRepository.findById(pp1.getProjectProductId()).get());
    }

    @Test
    void find() {
        ProjectProduct pp1 = projectProductServiceImpl.create(projectProduct);
        Assertions.assertNotNull(projectProductServiceImpl.find(pp1.getProjectProductId()));
    }

    @Test
    void update() {
        ProjectProduct pp1 = projectProductServiceImpl.create(projectProduct);
        Date d = pp1.getTimeCreated();
        pp1.setTimeCreated(new Date());
        ProjectProduct pp2 = projectProductServiceImpl.update(pp1.getProjectProductId(), pp1);
        Assertions.assertNotEquals(pp2.getTimeCreated(),d);
    }

    @Test
    void delete() {
        ProjectProduct pp1 = projectProductServiceImpl.create(projectProduct);
        projectProductServiceImpl.delete(pp1);
        Assertions.assertFalse(projectProductRepository.findById(pp1.getProjectProductId()).isPresent());
    }
}