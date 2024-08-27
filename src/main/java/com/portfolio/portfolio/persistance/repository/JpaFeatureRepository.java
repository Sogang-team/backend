package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFeatureRepository extends JpaRepository<Feature, Long> {
}
