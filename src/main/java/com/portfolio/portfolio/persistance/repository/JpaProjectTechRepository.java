package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.ProjectTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectTechRepository extends JpaRepository<ProjectTech, Long> {
}
