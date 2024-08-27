package com.portfolio.portfolio.presentation.dto.request;

public record UpdateRetrospectiveRequest(

        Long retrospectiveId,

        String retrospectiveTitle,

        String retrospectiveContent

) {
}
