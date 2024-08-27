package com.portfolio.portfolio.presentation.dto.response;

import com.portfolio.portfolio.persistance.domain.User;
import com.portfolio.portfolio.persistance.domain.UserCertification;
import com.portfolio.portfolio.persistance.domain.UserEducation;
import com.portfolio.portfolio.persistance.domain.UserTech;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ReadUserResponse(
        String userName,
        String userEnglishName,
        String userImage,
        LocalDateTime userBirth,
        String simpleIntroduction,
        String work,
        String githubLink,
        String gmailLink,
        List<ReadEducationResponse> educationList,
        List<ReadTechStackResponse> techStackList,
        List<ReadCertificationResponse> certificationList
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
                .educationList(user.getUserEducationList().stream().map(UserEducation::getEducation).map(ReadEducationResponse::from).toList())
                .techStackList(user.getUserTechList().stream().map(UserTech::getTechStack).map(ReadTechStackResponse::from).toList())
                .certificationList(user.getUserCertificationList().stream().map(UserCertification::getCertification).map(ReadCertificationResponse::from).toList())
                .build();
    }
}
