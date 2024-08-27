package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateUserCertificationRequest;

public interface UserCertificationService {
    Long createUserCertification(CreateUserCertificationRequest request);
}
