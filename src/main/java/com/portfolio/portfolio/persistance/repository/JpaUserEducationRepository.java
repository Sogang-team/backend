package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.UserEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserEducationRepository extends JpaRepository<UserEducation, Long> {
    List<UserEducation> findByUser_userId(Long userId);
}
