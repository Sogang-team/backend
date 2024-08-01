package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.User;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateUserRequest
        (
                @NotNull
                String userName,

                String userImage,

                @NotNull
                LocalDateTime userBirth,

                @NotNull
                String simpleIntroduction,

                @NotNull
                String work,

                String githubLink,

                String gmailLink
        ) {

    public User toEntity() {
        return User.builder()
                .userId(null)
                .userName(userName)
                .userImage(userImage)
                .userBirth(userBirth)
                .simpleIntroduction(simpleIntroduction)
                .work(work)
                .githubLink(githubLink)
                .gmailLink(gmailLink)
                .build();
    }

}
