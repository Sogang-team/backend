package com.portfolio.portfolio.persistance.domain;

import com.portfolio.portfolio.presentation.dto.request.UpdateUserRequest;
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

    @Column(name = "user_english_name", nullable = false)
    private String userEnglishName;

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
    public User(Long userId, String userName, String userEnglishName, String userImage, LocalDateTime userBirth, String simpleIntroduction, String work, String githubLink, String gmailLink) {
        this.userId = userId;
        this.userName = userName;
        this.userEnglishName = userEnglishName;
        this.userImage = userImage;
        this.userBirth = userBirth;
        this.simpleIntroduction = simpleIntroduction;
        this.work = work;
        this.githubLink = githubLink;
        this.gmailLink = gmailLink;
    }

    public void updateName(String userName) {
        this.userName = userName;
    }

    public void updateImage(String userImage) {
        this.userImage = userImage;
    }

    public void updateBirth(LocalDateTime userBirth) {
        this.userBirth = userBirth;
    }

    public void updateSimpleIntroduction(String simpleIntroduction) {
        this.simpleIntroduction = simpleIntroduction;
    }

    public void updateWork(String work) {
        this.work = work;
    }

    public void updateGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public void updateGmailLink(String gmailLink) {
        this.gmailLink = gmailLink;
    }

    public void updateUserEnglishName(String userEnglishName) {
        this.userEnglishName = userEnglishName;
    }

    public void updateAll(UpdateUserRequest request) {
        updateName(request.userName());
        updateUserEnglishName(request.userEnglishName());
        updateImage(request.userImage());
        updateBirth(request.userBirth());
        updateSimpleIntroduction(request.simpleIntroduction());
        updateWork(request.work());
        updateGithubLink(request.githubLink());
        updateGmailLink(request.gmailLink());
    }
}
