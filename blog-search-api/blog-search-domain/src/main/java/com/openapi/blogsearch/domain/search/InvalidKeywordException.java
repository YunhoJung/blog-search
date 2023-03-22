package com.openapi.blogsearch.domain.search;

public class InvalidKeywordException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "keyword does not exist";

    public InvalidKeywordException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidKeywordException(String message) {
        super(message);
    }

}
