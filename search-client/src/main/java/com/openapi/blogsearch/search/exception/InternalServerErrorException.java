package com.openapi.blogsearch.search.exception;

public class InternalServerErrorException extends RuntimeException {

    private static final String MESSAGE = "Internal server error";

    protected InternalServerErrorException() {
        super(MESSAGE);
    }

    protected InternalServerErrorException(String message) {
        super(message);
    }

}
