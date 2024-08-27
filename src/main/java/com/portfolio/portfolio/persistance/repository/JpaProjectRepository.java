package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUser_userId(Long userId);
}
