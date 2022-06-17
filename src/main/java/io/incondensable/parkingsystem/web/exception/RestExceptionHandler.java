package io.incondensable.parkingsystem.web.exception;

import io.incondensable.parkingsystem.common.BusinessException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class RestExceptionHandler {

    private final MessageSource messageSource;

    public RestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity handleBusinessException(BusinessException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(getErrorMessage(exception), httpStatus);
    }

    private String getErrorMessage(BusinessException exception) {
        return messageSource.getMessage(
                exception.getExceptionMessage().getMessage(),
                exception.getExceptionMessage().getInput(),
                Locale.getDefault()); // default is en_IR
    }

}
