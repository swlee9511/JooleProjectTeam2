package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import com.javatraining.jooleprojectteam2.Repository.ProjectProductRepository;
import org.springframework.beans.factory.annotation.Autowired;


public interface ProjectProductService {
    ProjectProduct create (ProjectProduct projectproduct);
    ProjectProduct find (int projectProductId);
    ProjectProduct update (int projectProductId, ProjectProduct projectproduct);
    void delete (ProjectProduct projectproduct);
}
