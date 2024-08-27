package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.UserTech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserTechRepository extends JpaRepository<UserTech, Long> {
    List<UserTech> findByUser_userId(Long userId);
    void deleteByUser_userId(Long userId);
    void deleteByTechStack_techStackId(Long techStackId);
}
