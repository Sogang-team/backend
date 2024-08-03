package com.portfolio.portfolio.presentation.dto.response;

import com.portfolio.portfolio.persistance.domain.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReadUserResponse(
        String userName,
        String userEnglishName,
        String userImage,
        LocalDateTime userBirth,
        String simpleIntroduction,
        String work,
        String githubLink,
        String gmailLink
    ) {

    public static ReadUserResponse from(User user) {
        return ReadUserResponse.builder()
                .userName(user.getUserName())
                .userEnglishName(user.getUserEnglishName())
                .userImage(user.getUserImage())
                .userBirth(user.getUserBirth())
                .simpleIntroduction(user.getSimpleIntroduction())
                .work(user.getWork())
                .githubLink(user.getGithubLink())
                .gmailLink(user.getGmailLink())
                .build();
    }
}
