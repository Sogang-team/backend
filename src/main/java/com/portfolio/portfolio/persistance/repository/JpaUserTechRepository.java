package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.UserTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserTechRepository extends JpaRepository<UserTech, Long> {
}
