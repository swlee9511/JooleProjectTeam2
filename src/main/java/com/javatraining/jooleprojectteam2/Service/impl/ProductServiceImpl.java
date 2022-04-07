package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Exception.ProductDoesntExistException;
import com.javatraining.jooleprojectteam2.Repository.ProductRepository;
import com.javatraining.jooleprojectteam2.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product create(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Product find(int productId) throws ProductDoesntExistException {
        Optional<Product> tmp = productRepository.findById(productId);
        if (!tmp.isPresent()) {
            throw new ProductDoesntExistException("Product Doesn't exist");
        } else {
            return tmp.get();
        }
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(int productId) {
        productRepository.deleteById(productId);
    }
}
