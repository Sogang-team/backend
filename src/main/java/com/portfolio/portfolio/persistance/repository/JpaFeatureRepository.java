package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaFeatureRepository extends JpaRepository<Feature, Long> {
    List<Feature> findByProject_projectId(Long projectId);
}
