package com.javatraining.jooleprojectteam2.Service;

import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    User create(User user);
    User find(String username);
    User update(User user);
    User delete(User user);
}
