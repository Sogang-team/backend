package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTechStackRepository extends JpaRepository<TechStack, Long> {
}
