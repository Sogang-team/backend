package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_title", nullable = false)
    private String projectTitle;

    @Column(name = "project_start_date", nullable = false)
    private LocalDateTime projectStartDate;

    @Column(name = "project_end_date", nullable = false)
    private LocalDateTime projectEndDate;

    @Column(name = "developer_count", nullable = false)
    private Integer developerCount;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "project_url")
    private String projectUrl;

    @Column(name = "represent_image")
    private String representImage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ProjectTech> projectTechList = new ArrayList<>();

    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Feature> featureList = new ArrayList<>();

    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Retrospective> retrospectiveList = new ArrayList<>();

    @Builder
    public Project(Long projectId, String projectTitle, LocalDateTime projectStartDate, LocalDateTime projectEndDate, Integer developerCount, String role, String projectUrl, String representImage, User user, List<ProjectTech> projectTechList, List<Feature> featureList, List<Retrospective> retrospectiveList) {
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.developerCount = developerCount;
        this.role = role;
        this.projectUrl = projectUrl;
        this.representImage = representImage;
        this.user = user;
        this.projectTechList = projectTechList;
        this.featureList = featureList;
        this.retrospectiveList = retrospectiveList;
    }

    public void updateProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public void updateProjectStartDate(LocalDateTime projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public void updateProjectEndDate(LocalDateTime projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public void updateDeveloperCount(Integer developerCount) {
        this.developerCount = developerCount;
    }

    public void updateRole(String role) {
        this.role = role;
    }

    public void updateProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public void updateRepresentImage(String representImage) {
        this.representImage = representImage;
    }

}
