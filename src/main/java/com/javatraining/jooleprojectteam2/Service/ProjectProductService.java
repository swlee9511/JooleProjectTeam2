package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import com.javatraining.jooleprojectteam2.Repository.ProjectProductRepository;
import org.springframework.beans.factory.annotation.Autowired;


public interface ProjectProductService {
    ProjectProduct create (ProjectProduct projectproduct);
    ProjectProduct find (String projectProductId);
    ProjectProduct update (String projectProductId, ProjectProduct projectproduct);
    ProjectProduct delete (ProjectProduct projectproduct);

}
