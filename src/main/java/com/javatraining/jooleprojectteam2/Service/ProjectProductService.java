package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Exception.ProjectProductDoesntExistException;
import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import com.javatraining.jooleprojectteam2.Repository.ProjectProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


public interface ProjectProductService {
    ProjectProduct create (ProjectProduct projectproduct);
    ProjectProduct find(int id) throws ProjectProductDoesntExistException;
    ProjectProduct update(int id, ProjectProduct projectproduct) throws ProjectProductDoesntExistException;
    void delete (ProjectProduct projectproduct);

    List<ProjectProduct> findAllProducts(int projectId);
    List<ProjectProduct> findAllProjects(int resourceId);
}
