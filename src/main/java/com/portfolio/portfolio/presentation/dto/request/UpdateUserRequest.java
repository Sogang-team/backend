package com.portfolio.portfolio.presentation.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateUserRequest(

        @NotNull
        Long userId,

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
}
