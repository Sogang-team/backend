package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tech_stack")
public class TechStack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tech_stack_id")
    private Long techStackId;

    @Column(name = "tech_stack_name", nullable = false)
    private String techStackName;

    @Column(name = "tech_stack_image")
    private String techStackImage;

    @Builder
    public TechStack(Long techStackId, String techStackName, String techStackImage) {
        this.techStackId = techStackId;
        this.techStackName = techStackName;
        this.techStackImage = techStackImage;
    }
}
