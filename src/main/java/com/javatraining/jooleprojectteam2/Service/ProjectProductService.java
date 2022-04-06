package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Repository.ProjectProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectProductService {
    @Autowired
    private ProjectProductRepository projectProductRepository;
}
