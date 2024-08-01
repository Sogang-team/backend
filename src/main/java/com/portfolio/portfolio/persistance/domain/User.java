package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_image")
    private String userImage;

    @Column(name = "user_birth", nullable = false)
    private LocalDateTime userBirth;

    @Column(name = "simple_introduction", columnDefinition = "TEXT")
    private String simpleIntroduction;

    @Column(name = "work", nullable = false)
    private String work;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "gmail_link")
    private String gmailLink;

    @Builder
    public User(Long userId, String userName, String userImage, LocalDateTime userBirth, String simpleIntroduction, String work, String githubLink, String gmailLink) {
        this.userId = userId;
        this.userName = userName;
        this.userImage = userImage;
        this.userBirth = userBirth;
        this.simpleIntroduction = simpleIntroduction;
        this.work = work;
        this.githubLink = githubLink;
        this.gmailLink = gmailLink;
    }
}
