package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.Retrospective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRetrospectiveRepository extends JpaRepository<Retrospective, Long> {
}
