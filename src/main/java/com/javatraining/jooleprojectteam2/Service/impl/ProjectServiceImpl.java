package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Exception.ProjectDoesntExistException;
import com.javatraining.jooleprojectteam2.Repository.ProjectRepository;
import com.javatraining.jooleprojectteam2.Service.ProductService;
import com.javatraining.jooleprojectteam2.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findOne(int projectId) throws ProjectDoesntExistException {
         Optional<Project> tmp = projectRepository.findById(projectId);
         if (!tmp.isPresent()) {
             throw new ProjectDoesntExistException("Project Doesn't exist");
         } else {
             return tmp.get();
         }
    }

    @Override
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void delete(int projectId) {
        projectRepository.deleteById(projectId);
    }
}
