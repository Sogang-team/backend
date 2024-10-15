package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.ProjectService;
import com.portfolio.portfolio.application.service.StorageService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.Project;
import com.portfolio.portfolio.persistance.domain.User;
import com.portfolio.portfolio.persistance.repository.JpaProjectRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateProjectRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateProjectRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final JpaProjectRepository projectRepository;
    private final JpaUserRepository userRepository;
    private final StorageService storageService;

    @Transactional(readOnly = true)
    @Override
    public ReadProjectResponse getProjectById(Long projectId) {
        return ReadProjectResponse.from(projectRepository.findById(projectId)
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("일치하는 프로젝트를 찾을 수 없습니다.",404, LocalDateTime.now())
                )));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReadProjectResponse> getProjectsByUserId(Long userId) {
        return projectRepository.findByUser_userId(userId).stream().map(ReadProjectResponse::from).toList();
    }

    @Transactional
    @Override
    public Long createProject(CreateProjectRequest request, MultipartFile file) throws IOException {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        Project project = null;

        if(file != null && !file.isEmpty()) {
            String imageUrl = storageService.uploadFirebaseBucket(file, request.projectTitle() + UUID.randomUUID());
            CreateProjectRequest createProjectRequest = CreateProjectRequest.updateImage(imageUrl, request);
            project = projectRepository.save(createProjectRequest.toEntity(user));
        } else {
            project = projectRepository.save(request.toEntity(user));
        }

        return project.getProjectId();
    }

    @Transactional
    @Override
    public void updateProjectTitle(UpdateProjectRequest request) {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        project.updateProjectTitle(request.projectTitle());
    }

    @Transactional
    @Override
    public void updateProjectStartDate(UpdateProjectRequest request) {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        project.updateProjectStartDate(request.projectStartDate());
    }

    @Transactional
    @Override
    public void updateProjectEndDate(UpdateProjectRequest request) {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        project.updateProjectEndDate(request.projectEndDate());
    }

    @Transactional
    @Override
    public void updateProjectDeveloperCount(UpdateProjectRequest request) {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        project.updateProjectTitle(request.projectTitle());
    }

    @Transactional
    @Override
    public void updateProjectRole(UpdateProjectRequest request) {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        project.updateRole(request.role());
    }

    @Transactional
    @Override
    public void updateProjectUrl(UpdateProjectRequest request) {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        project.updateProjectUrl(request.projectUrl());
    }

    @Transactional
    @Override
    public void updateRepresentImage(UpdateProjectRequest request, MultipartFile file) throws IOException {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        String imageUrl = storageService.uploadFirebaseBucket(file, request.projectTitle() + UUID.randomUUID());

        project.updateRepresentImage(imageUrl);
    }

    @Transactional
    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
