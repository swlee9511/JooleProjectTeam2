package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.Project_Product;
import com.javatraining.jooleprojectteam2.Entity.User;
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
class Project_ProductRepositoryTest {

    @Autowired
    Project_ProductRepository project_productRepository;
    @Test
    public void saveTestAll(){
        Project_Product project_product = new Project_Product();
        project_product.setTimeCreated(new Date());
        Project_Product res =  project_productRepository.save(project_product);
        Assertions.assertNotEquals(null, res);
    }

    @Test
    public void findByIdTest(){
        Project_Product project_product = new Project_Product();
        project_product.setTimeCreated(new Date());
        Project_Product tmp =  project_productRepository.save(project_product);
        Optional<Project_Product> res = project_productRepository.findById(tmp.getProject_productId());
        Assertions.assertNotEquals(null,res.get());
    }
}