package com.portfolio.portfolio.presentation.dto.response;

import com.portfolio.portfolio.persistance.domain.Certification;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReadCertificationResponse
        (
                Long certificationId,

                String certificationName,

                String certificationContent,

                LocalDateTime certificationDate
        )
{
    public static ReadCertificationResponse from(Certification certification) {
        return ReadCertificationResponse.builder()
                .certificationId(certification.getCertificationId())
                .certificationName(certification.getCertificationName())
                .certificationContent(certification.getCertificationContent())
                .certificationDate(certification.getCertificationDate())
                .build();
    }
}
