package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEducationRepository extends JpaRepository<Education, Long> {
}
