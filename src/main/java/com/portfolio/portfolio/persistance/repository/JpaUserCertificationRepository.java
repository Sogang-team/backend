package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.UserCertification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserCertificationRepository extends JpaRepository<UserCertification, Long> {
    List<UserCertification> findByUser_userId(Long userId);
    void deleteByUser_userId(Long userId);
    void deleteByCertification_certificationId(Long certificationId);
}
