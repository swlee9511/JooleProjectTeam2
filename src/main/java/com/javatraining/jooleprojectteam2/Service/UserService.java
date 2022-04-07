package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;


public interface UserService {
    User create(User user);
    User find(String username);
    User updateProfile(User user);
    void delete(String userName);

    Set<Project> findAllProjectInUser(String username);
}
