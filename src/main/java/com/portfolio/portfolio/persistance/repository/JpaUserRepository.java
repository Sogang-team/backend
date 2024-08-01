package com.portfolio.portfolio.persistance.repository;

import com.portfolio.portfolio.persistance.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {
}
