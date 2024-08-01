package com.portfolio.portfolio.common.exception;

import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final ErrorStatus errorStatus;

    public ApplicationException(ErrorStatus errorStatus) {
        this.errorStatus = errorStatus;
    }
}
