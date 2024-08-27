package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.Project;
import com.portfolio.portfolio.persistance.domain.User;

import java.time.LocalDateTime;

public record CreateProjectRequest(

        String projectTitle,

        LocalDateTime projectStartDate,

        LocalDateTime projectEndDate,

        Integer developerCount,

        String role,

        String projectUrl,

        String representImage,

        Long userId
) {
    public Project toEntity(User user) {
        return Project.builder()
                .projectId(null)
                .projectTitle(projectTitle)
                .projectStartDate(projectStartDate)
                .projectEndDate(projectEndDate)
                .developerCount(developerCount)
                .role(role)
                .projectUrl(projectUrl)
                .representImage(representImage)
                .user(user)
                .build();
    }
}
