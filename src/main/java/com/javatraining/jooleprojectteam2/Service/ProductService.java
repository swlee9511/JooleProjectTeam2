package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
}
