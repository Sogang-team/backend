package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateProjectRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateProjectRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadProjectResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProjectService {
    ReadProjectResponse getProjectById(Long projectId);
    List<ReadProjectResponse> getProjectsByUserId(Long userId);
    Long createProject(CreateProjectRequest request, MultipartFile file) throws IOException;
    void updateProjectTitle(UpdateProjectRequest request);
    void updateProjectStartDate(UpdateProjectRequest request);
    void updateProjectEndDate(UpdateProjectRequest request);
    void updateProjectDeveloperCount(UpdateProjectRequest request);
    void updateProjectRole(UpdateProjectRequest request);
    void updateProjectUrl(UpdateProjectRequest request);
    void updateRepresentImage(UpdateProjectRequest request, MultipartFile file) throws IOException;
    void deleteProject(Long projectId);
}