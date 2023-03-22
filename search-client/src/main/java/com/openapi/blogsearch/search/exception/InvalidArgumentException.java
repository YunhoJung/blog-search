package com.openapi.blogsearch.search.exception;

public class InvalidArgumentException extends RuntimeException {

    private static final String MESSAGE = "Bad reqeust";

    protected InvalidArgumentException() {
        super(MESSAGE);
    }

    protected InvalidArgumentException(String message) {
        super(message);
    }

}
