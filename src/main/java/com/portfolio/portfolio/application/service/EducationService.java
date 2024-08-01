package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateEducationRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateEducationRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadEducationResponse;

public interface EducationService {

    ReadEducationResponse getEducationById(Long educationId);
    Long createEducation(CreateEducationRequest request);
    void updateEducation(UpdateEducationRequest request);
    void deleteEducation(Long id);
}
