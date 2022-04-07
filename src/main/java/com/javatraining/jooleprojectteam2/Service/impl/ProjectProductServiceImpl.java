package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Exception.ProjectProductAlreadyExistException;
import com.javatraining.jooleprojectteam2.Exception.ProjectProductDoesntExistException;
import com.javatraining.jooleprojectteam2.Exception.UserAlreadyExistException;
import com.javatraining.jooleprojectteam2.Exception.UserDoesntExistException;
import com.javatraining.jooleprojectteam2.Repository.ProjectProductRepository;
import com.javatraining.jooleprojectteam2.Repository.UserRepository;
import com.javatraining.jooleprojectteam2.Service.ProjectProductService;
import com.javatraining.jooleprojectteam2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {

    @Autowired
    private ProjectProductRepository projectProductRepository;

    @Override
    public ProjectProduct create(ProjectProduct projectproduct) throws ProjectProductAlreadyExistException {
//        if (projectProductRepository.existsByProjectAndProduct(projectproduct.getProject(), projectproduct.getProduct())) {
//            throw new ProjectProductAlreadyExistException("ProjectProduct already exists");
//        }
        if (projectProductRepository.existsById(projectproduct.getProjectProductId())) {
            throw new ProjectProductAlreadyExistException("ProjectProduct already exists");
        }
        ProjectProduct res = projectProductRepository.save(projectproduct);
        return res;
    }

    @Override
    public ProjectProduct find(int id) throws ProjectProductDoesntExistException {
        Optional<ProjectProduct> tmp = projectProductRepository.findById(id);
        if (!tmp.isPresent()) {
            throw new ProjectProductDoesntExistException("ProjectProduct doesn't exist");
        }
        return tmp.get();
    }

    @Override
    public ProjectProduct update(int id, ProjectProduct projectproduct) throws ProjectProductDoesntExistException {
        Optional<ProjectProduct> tmp = projectProductRepository.findById(id);
        if (!tmp.isPresent()) {
            throw new ProjectProductDoesntExistException("ProjectProduct doesn't exist");
        }
        return projectProductRepository.save(projectproduct);
    }

    @Override
    public void delete(ProjectProduct projectproduct) {

        projectProductRepository.delete(projectproduct);
    }

}