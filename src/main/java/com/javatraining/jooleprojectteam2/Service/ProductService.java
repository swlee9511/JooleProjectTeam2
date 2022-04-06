package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Entity.MechanicalDetail;
import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface ProductService {
    Product create(Product product);
    Product find(String productId);
    Product update(String productId, Product product);
    Product delete(Product product);

    List<Product> searchBynameAndMechanicDetail(String searchInput, MechanicalDetail md);
    List<Product> featureFilter(int modelYear, String brand, int airflow, int maxPower, int soundAtMaxSpeed, int fanSweepDiameter, int height);// ???parameter changes with product type
}
