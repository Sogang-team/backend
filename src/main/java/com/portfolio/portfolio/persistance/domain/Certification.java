package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "certification")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certification_id")
    private Long certificationId;

    @Column(name = "certification_name", nullable = false)
    private String certificationName;

    @Column(name = "certification_content", columnDefinition = "TEXT", nullable = false)
    private String certificationContent;

    @Column(name = "certification_date", nullable = false)
    private LocalDateTime certificationDate;

    @Builder
    public Certification(Long certificationId, String certificationName, String certificationContent, LocalDateTime certificationDate) {
        this.certificationId = certificationId;
        this.certificationName = certificationName;
        this.certificationContent = certificationContent;
        this.certificationDate = certificationDate;
    }

    public void updateCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }

    public void updateCertificationContent(String certificationContent) {
        this.certificationContent = certificationContent;
    }

    public void updateCertificationDate(LocalDateTime certificationDate) {
        this.certificationDate = certificationDate;
    }
}
