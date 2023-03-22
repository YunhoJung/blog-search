package com.openapi.blogsearch.search;

public class InvalidApiSpecException extends RuntimeException {

    private static final String MESSAGE = "Json parsing exception";

    protected InvalidApiSpecException() {
        super(MESSAGE);
    }

    protected InvalidApiSpecException(String message) {
        super(message);
    }
}
