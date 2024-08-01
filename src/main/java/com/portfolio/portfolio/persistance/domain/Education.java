package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
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

}
