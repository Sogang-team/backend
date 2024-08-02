package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateUserTechRequest;

public interface UserTechStackService {
    Long createUserTechStack(CreateUserTechRequest request);
}
