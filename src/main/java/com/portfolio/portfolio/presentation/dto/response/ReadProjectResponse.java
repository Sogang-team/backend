package com.portfolio.portfolio.presentation.dto.response;

import com.portfolio.portfolio.persistance.domain.Project;
import com.portfolio.portfolio.persistance.domain.ProjectTech;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ReadProjectResponse(

        Long projectId,

        String projectTitle,

        LocalDateTime projectStartDate,

        LocalDateTime projectEndDate,

        Integer developerCount,

        String role,

        String projectUrl,

        String representImage,

        Long userId,

        List<ReadTechStackResponse> techList
) {
    public static ReadProjectResponse from(Project project) {
         return ReadProjectResponse.builder()
                 .projectId(project.getProjectId())
                 .projectTitle(project.getProjectTitle())
                 .projectStartDate(project.getProjectStartDate())
                 .projectEndDate(project.getProjectEndDate())
                 .developerCount(project.getDeveloperCount())
                 .role(project.getRole())
                 .projectUrl(project.getProjectUrl())
                 .representImage(project.getRepresentImage())
                 .userId(project.getUser().getUserId())
                 .techList(project.getProjectTechList().stream().map(ProjectTech::getTechStack).map(ReadTechStackResponse::from).toList())
                 .build();

    }
}
