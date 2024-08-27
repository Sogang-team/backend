package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.Education;

import java.time.LocalDateTime;

public record CreateEducationRequest(

        String educationTitle,

        String educationContent,

        LocalDateTime educationStartDate,

        LocalDateTime educationEndDate
)
{
    public Education toEntity() {
        return Education.builder()
                .educationId(null)
                .educationTitle(educationTitle)
                .educationContent(educationContent)
                .educationStartDate(educationStartDate)
                .educationEndDate(educationEndDate)
                .build();
    }
}
