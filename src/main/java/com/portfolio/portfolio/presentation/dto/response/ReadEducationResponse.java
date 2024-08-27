package com.portfolio.portfolio.presentation.dto.response;

import com.portfolio.portfolio.persistance.domain.Education;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReadEducationResponse(

        Long educationId,

        String educationTitle,

        String educationContent,

        LocalDateTime educationStartDate,

        LocalDateTime educationEndDate
) {

    public static ReadEducationResponse from(Education education) {
        return ReadEducationResponse.builder()
                .educationId(education.getEducationId())
                .educationTitle(education.getEducationTitle())
                .educationContent(education.getEducationContent())
                .educationStartDate(education.getEducationStartDate())
                .educationEndDate(education.getEducationEndDate())
                .build();
    }
}
