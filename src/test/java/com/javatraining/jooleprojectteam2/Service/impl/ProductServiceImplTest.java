package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Repository.ProductRepository;
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
class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productServiceImpl;
    @Autowired
    ProductRepository productRepository;

    private Product product;
    @BeforeEach
    public void setup() {
        this.product = new Product();
        product.setBrand("dell");
    }
    @Test
    void create() {
        Product p = productServiceImpl.create(product);
        Assertions.assertEquals("dell", productRepository.findById(p.getResourceId()).get().getBrand());
    }

    @Test
    void find() {
        Product p = productServiceImpl.create(product);
        Product p2 = productServiceImpl.find(p.getResourceId());
        Assertions.assertEquals(p.getBrand(), p2.getBrand());
    }

    @Test
    void update() {
        Product p = productServiceImpl.create(product);
        String tmp = p.getBrand();
        product.setBrand("HP");
        Product p2 = productServiceImpl.update(product);
        System.out.println(p.getBrand());
        Assertions.assertNotEquals(tmp, p2.getBrand());//why p.getBrand == p2.getBrand in this case?
    }

    @Test
    void delete() {
        Product p = productServiceImpl.create(product);
        int id = p.getResourceId();
        productServiceImpl.delete(p.getResourceId());
        Assertions.assertFalse(productRepository.findById(id).isPresent());
    }
}