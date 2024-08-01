package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.UserEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserEducationRepository extends JpaRepository<UserEducation, Long> {
}
