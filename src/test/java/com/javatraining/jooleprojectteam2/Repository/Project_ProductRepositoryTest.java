package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class Project_ProductRepositoryTest {

    @Autowired
    ProjectProductRepository project_productRepository;
    @Test
    public void saveTestAll(){
        ProjectProduct project_product = new ProjectProduct();
        project_product.setTimeCreated(new Date());
        ProjectProduct res =  project_productRepository.save(project_product);
        Assertions.assertNotEquals(null, res);
    }

    @Test
    public void findByIdTest(){
        ProjectProduct project_product = new ProjectProduct();
        project_product.setTimeCreated(new Date());
        ProjectProduct tmp =  project_productRepository.save(project_product);
        Optional<ProjectProduct> res = project_productRepository.findById(tmp.getProjectProductId());
        Assertions.assertNotEquals(null,res.get());
    }
}