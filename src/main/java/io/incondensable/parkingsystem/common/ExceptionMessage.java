package io.incondensable.parkingsystem.common;

import java.time.LocalDateTime;

public class ExceptionMessage {
    private String message;
    private Object[] input;
    private LocalDateTime time;

    public ExceptionMessage(String message, Object[] input) {
        this.message = message;
        this.input = input;
        this.time = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public Object[] getInput() {
        return input;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
