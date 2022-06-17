package io.incondensable.parkingsystem.common;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private final ExceptionMessage exceptionMessage;

    public BusinessException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }
}
