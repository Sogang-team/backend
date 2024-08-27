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
@Table(name = "education")
public class Education {

    @Id
    @Column(name = "education_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    @Column(name = "education_title", nullable = false)
    private String educationTitle;

    @Column(name = "education_content", nullable = false, columnDefinition = "TEXT")
    private String educationContent;

    @Column(name = "education_start_date", nullable = false)
    private LocalDateTime educationStartDate;

    @Column(name = "education_end_date", nullable = false)
    private LocalDateTime educationEndDate;

    @Builder
    public Education(Long educationId, String educationTitle, String educationContent, LocalDateTime educationStartDate, LocalDateTime educationEndDate) {
        this.educationId = educationId;
        this.educationTitle = educationTitle;
        this.educationContent = educationContent;
        this.educationStartDate = educationStartDate;
        this.educationEndDate = educationEndDate;
    }

    public void updateEducationTitle(String educationTitle) {
        this.educationTitle = educationTitle;
    }

    public void updateEducationContent(String educationContent) {
        this.educationContent = educationContent;
    }

    public void updateEducationStartDate(LocalDateTime educationStartDate) {
        this.educationStartDate = educationStartDate;
    }

    public void updateEducationEndDate(LocalDateTime educationEndDate) {
        this.educationEndDate = educationEndDate;
    }
}
