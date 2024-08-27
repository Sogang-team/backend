package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.Certification;

import java.time.LocalDateTime;

public record CreateCertificationRequest(

        String certificationName,

        String certificationContent,

        LocalDateTime certificationDate
) {
    public Certification toEntity() {
        return Certification.builder()
                .certificationId(null)
                .certificationName(certificationName)
                .certificationContent(certificationContent)
                .certificationDate(certificationDate)
                .build();
    }
}
