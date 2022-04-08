package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import com.javatraining.jooleprojectteam2.Entity.Exception.ProjectProductDoesntExistException;
import com.javatraining.jooleprojectteam2.Repository.ProjectProductRepository;
import com.javatraining.jooleprojectteam2.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {

    @Autowired
    private ProjectProductRepository projectProductRepository;

    @Override
    public ProjectProduct create(ProjectProduct projectproduct) {
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
