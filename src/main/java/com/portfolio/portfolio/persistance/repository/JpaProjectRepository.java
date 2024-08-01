package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectRepository extends JpaRepository<Project, Long> {
}
