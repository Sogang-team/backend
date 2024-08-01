package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
}
