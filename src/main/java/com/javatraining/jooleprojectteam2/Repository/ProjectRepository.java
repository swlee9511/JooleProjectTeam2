package com.javatraining.jooleprojectteam2.Repository;

import com.javatraining.jooleprojectteam2.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
