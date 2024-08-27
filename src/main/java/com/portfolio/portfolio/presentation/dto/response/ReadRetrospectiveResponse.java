package com.portfolio.portfolio.presentation.dto.response;

import com.portfolio.portfolio.persistance.domain.Retrospective;
import lombok.Builder;

@Builder
public record ReadRetrospectiveResponse(

        Long retrospectiveId,

        String retrospectiveTitle,

        String retrospectiveContent
) {
    public static ReadRetrospectiveResponse from(Retrospective retrospective) {
        return ReadRetrospectiveResponse.builder()
                .retrospectiveId(retrospective.getRetrospectiveId())
                .retrospectiveTitle(retrospective.getRetrospectiveTitle())
                .retrospectiveContent(retrospective.getRetrospectiveContent())
                .build();
    }
}
