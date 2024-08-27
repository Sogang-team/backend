package com.portfolio.portfolio.presentation.dto.request;

import java.time.LocalDateTime;

public record UpdateCertificationRequest(

        Long certificationId,

        String certificationName,

        String certificationContent,

        LocalDateTime certificationDate
) {
}
