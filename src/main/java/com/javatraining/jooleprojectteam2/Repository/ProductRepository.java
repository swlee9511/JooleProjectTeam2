package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByBrandEndingWith (String str);
    List<Product> findByCertificationContaining (String str);
    List<Product> findByModelYearGreaterThan (int year);
}
