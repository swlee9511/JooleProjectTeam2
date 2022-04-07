package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Integer> {

    //find ProjectProduct with Product with field Brand which contains str
    List<ProjectProduct> findByProduct_BrandContains(String str);

    boolean existsByProjectAndProduct(Project project, Product product);

    Optional<ProjectProduct> findByProjectProductId(int id);

    Optional<ProjectProduct> findByProjectProduct(ProjectProduct projectproduct);
}
