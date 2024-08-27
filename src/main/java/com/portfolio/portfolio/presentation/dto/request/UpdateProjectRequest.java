package com.portfolio.portfolio.presentation.dto.request;

import java.time.LocalDateTime;

public record UpdateProjectRequest(

        Long projectId,

        String projectTitle,

        LocalDateTime projectStartDate,

        LocalDateTime projectEndDate,

        Integer developerCount,

        String role,

        String projectUrl,

        String representImage
) {
}
