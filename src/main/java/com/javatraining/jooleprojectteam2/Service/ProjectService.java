package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectService {
    Project create(User user, Project project);
    Project findOne(String projectId);
    List<Project> findAll(User user);
    Project update(String projectId, Project project);
    Project delete(User user, String projectId);
}
