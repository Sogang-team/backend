package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCertificationRepository extends JpaRepository<Certification, Long> {
}
