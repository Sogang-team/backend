package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.User;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
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

    public static CreateUserRequest updateImageUrl(CreateUserRequest request, String imageUrl) {
        return CreateUserRequest.builder()
                .userName(request.userName())
                .userImage(imageUrl)
                .userBirth(request.userBirth())
                .simpleIntroduction(request.simpleIntroduction())
                .work(request.simpleIntroduction())
                .githubLink(request.githubLink())
                .gmailLink(request.gmailLink())
                .build();
    }

}
