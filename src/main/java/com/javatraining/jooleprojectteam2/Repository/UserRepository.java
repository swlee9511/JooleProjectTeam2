package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
