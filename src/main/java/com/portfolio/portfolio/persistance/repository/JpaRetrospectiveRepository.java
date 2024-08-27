package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.Retrospective;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRetrospectiveRepository extends JpaRepository<Retrospective, Long> {
    List<Retrospective> findByProject_projectId(Long projectId);
}
