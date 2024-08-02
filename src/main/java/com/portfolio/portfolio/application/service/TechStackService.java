package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateTechStackRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadTechStackResponse;

import java.util.List;

public interface TechStackService {
    List<ReadTechStackResponse> getTechStackByUserId(Long userId);
    Long createTechStack(CreateTechStackRequest request);
    void deleteTechStack(Long techStackId);
}
