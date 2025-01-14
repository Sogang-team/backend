package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.persistance.domain.UserEducation;
import com.portfolio.portfolio.presentation.dto.request.CreateUserEducationRequest;

import java.util.List;

public interface UserEducationService {
    Long createUserEducation(CreateUserEducationRequest request);
}
