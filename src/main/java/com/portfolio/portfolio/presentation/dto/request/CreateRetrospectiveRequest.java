package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.Project;
import com.portfolio.portfolio.persistance.domain.Retrospective;

public record CreateRetrospectiveRequest(

        String retrospectiveTitle,

        String retrospectiveContent,

        Long projectId
) {
    public Retrospective toEntity(Project project) {
        return Retrospective.builder()
                .retrospectiveId(null)
                .retrospectiveTitle(retrospectiveTitle)
                .retrospectiveContent(retrospectiveContent)
                .project(project)
                .build();
    }
}
