package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.ProjectService;
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

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final JpaProjectRepository projectRepository;
    private final JpaUserRepository userRepository;

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
    public Long createProject(CreateProjectRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        Project project = projectRepository.save(request.toEntity(user));

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
    public void updateRepresentImage(UpdateProjectRequest request) {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        project.updateRepresentImage(request.representImage());
    }

    @Transactional
    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
