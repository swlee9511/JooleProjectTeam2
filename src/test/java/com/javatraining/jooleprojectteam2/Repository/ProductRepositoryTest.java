package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.Product;
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
    ProductRepository productRepository;
    @Test
    public void saveTest(){
        Product product = new Product();
        product.setTimeCreated(new Date());
        product.setLastUpdated(new Date());
        product.setBrand("Dell");
        product.setCertification("20220405");
        product.setModelYear(2022);
        Product res = productRepository.save(product);
        Assertions.assertNotEquals(null, res);
    }
    @Test
    public void findByIdTest() {
        Product product = new Product();
        product.setTimeCreated(new Date());
        product.setLastUpdated(new Date());
        product.setBrand("Dell");
        product.setCertification("20220405");
        product.setModelYear(2022);
        Product tmp = productRepository.save(product);
        Optional<Product> res = productRepository.findById(tmp.getResourceId());
        Assertions.assertNotEquals(null, res.get());
    }
}