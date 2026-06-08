package com.day11project2.ProjectManagerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.day11project2.ProjectManagerAPI.entity.Project;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {
}