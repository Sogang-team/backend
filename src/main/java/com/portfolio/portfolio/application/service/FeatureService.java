package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateFeatureRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateFeatureRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadFeatureResponse;

import java.util.List;

public interface FeatureService {
    ReadFeatureResponse getById(Long id);
    List<ReadFeatureResponse> getByProjectId(Long projectId);
    Long createFeature(CreateFeatureRequest createFeatureRequest);
    void updateTitle(UpdateFeatureRequest request);
    void updateContent(UpdateFeatureRequest request);
    void updateImage(UpdateFeatureRequest request, String imageUrl);
    void deleteById(Long id);
}