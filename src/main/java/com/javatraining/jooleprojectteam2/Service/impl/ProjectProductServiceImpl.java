package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import com.javatraining.jooleprojectteam2.Exception.ProjectProductDoesntExistException;
import com.javatraining.jooleprojectteam2.Repository.ProjectProductRepository;
import com.javatraining.jooleprojectteam2.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {

    @Autowired
    private ProjectProductRepository projectProductRepository;

    @Override
    public ProjectProduct create(ProjectProduct projectproduct) {
        return projectProductRepository.save(projectproduct);
    }

    @Override
    public ProjectProduct find(int id) throws ProjectProductDoesntExistException {
        Optional<ProjectProduct> tmp = projectProductRepository.findById(id);
        if (tmp.isEmpty()) {
            throw new ProjectProductDoesntExistException("ProjectProduct doesn't exist");
        }
        return tmp.get();
    }

    @Override
    public ProjectProduct update(int id, ProjectProduct projectproduct) throws ProjectProductDoesntExistException {
        Optional<ProjectProduct> tmp = projectProductRepository.findById(id);
        if (tmp.isEmpty()) {
            throw new ProjectProductDoesntExistException("ProjectProduct doesn't exist");
        }
        return projectProductRepository.save(projectproduct);
    }

    @Override
    public void delete(ProjectProduct projectproduct) {
        projectProductRepository.delete(projectproduct);
    }

    @Override
    public List<ProjectProduct> findAllProducts(int projectId) {
        return projectProductRepository.findByProject_ProjectId(projectId);
    }

    @Override
    public List<ProjectProduct> findAllProjects(int resourceId) {
        return projectProductRepository.findByProduct_ResourceId(resourceId);
    }
}
