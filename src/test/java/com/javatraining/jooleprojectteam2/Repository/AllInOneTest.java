package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.Project_Product;
import com.javatraining.jooleprojectteam2.Entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AllInOneTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    Project_ProductRepository project_productRepository;

    @Test
    public void saveAllTest(){
        User user = new User("forAll","owner","123456", new Date());
        Set<Project> forUserProject = new HashSet<>();

        Project project = new Project();
        project.setTimeCreated(new Date());
        project.setLastUpdated(new Date());

        Product product = new Product();
        product.setTimeCreated(new Date());
        product.setLastUpdated(new Date());
        product.setBrand("Dell");
        product.setCertification("20220405");
        product.setModel_year(2022);

        Project_Product project_product= new Project_Product();
        project_product.setTimeCreated(new Date());

        forUserProject.add(project);
        user.setProjectSets(forUserProject);
        project.setUser(user);

        Set<Project_Product> forProject = new HashSet<>();
        forProject.add(project_product);
        project.setProductSet(forProject);
        project_product.setProject(project);

        Set<Project_Product> forProduct = new HashSet<>();
        forProduct.add(project_product);
        product.setProductSet(forProduct);
        project_product.setProduct(product);

        User resUser = userRepository.save(user);
        Project resProJect = projectRepository.save(project);
        Product resProduct = productRepository.save(product);
        Project_Product resPP = project_productRepository.save(project_product);
        Assertions.assertEquals(user.getUser_name(), resPP.getProject().getUser().getUser_name());
    }
}
