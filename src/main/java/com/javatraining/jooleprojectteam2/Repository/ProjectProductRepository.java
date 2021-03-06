package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Integer> {

    //find ProjectProduct with Product with field Brand which contains str
    List<ProjectProduct> findByProduct_BrandContains(String str);
    List<ProjectProduct> findByProject_ProjectId(int projectId);
    List<ProjectProduct> findByProduct_ResourceId(int resourceId);
}
