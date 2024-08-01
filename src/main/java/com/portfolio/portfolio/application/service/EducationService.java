package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateEducationRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateEducationRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadEducationResponse;

import java.util.List;

public interface EducationService {

    ReadEducationResponse getEducationById(Long educationId);
    List<ReadEducationResponse> getEducationByUserId(Long userId);
    Long createEducation(CreateEducationRequest request);
    void updateEducationTitle(UpdateEducationRequest request);
    void updateEducationContent(UpdateEducationRequest request);
    void updateEducationStartDate(UpdateEducationRequest request);
    void updateEducationEndDate(UpdateEducationRequest request);
    void deleteEducation(Long id);
}
