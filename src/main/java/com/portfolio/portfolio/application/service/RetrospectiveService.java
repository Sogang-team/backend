package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateRetrospectiveRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateRetrospectiveRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadRetrospectiveResponse;

import java.util.List;

public interface RetrospectiveService {
    Long createRetrospective(CreateRetrospectiveRequest request);
    void updateRetrospectiveTitle(UpdateRetrospectiveRequest request);
    void updateRetrospectiveContent(UpdateRetrospectiveRequest request);
    ReadRetrospectiveResponse getRetrospectiveById(Long retrospectiveId);
    List<ReadRetrospectiveResponse> getRetrospectiveByProjectId(Long projectId);
    void deleteRetrospectiveById(Long retrospectiveId);
}
