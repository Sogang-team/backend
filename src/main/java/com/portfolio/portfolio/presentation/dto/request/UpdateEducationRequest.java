package com.portfolio.portfolio.presentation.dto.request;

import java.time.LocalDateTime;

public record UpdateEducationRequest(

        Long educationId,

        String educationTitle,

        String educationContent,

        LocalDateTime educationStartDate,

        LocalDateTime educationEndDate
) {
}
