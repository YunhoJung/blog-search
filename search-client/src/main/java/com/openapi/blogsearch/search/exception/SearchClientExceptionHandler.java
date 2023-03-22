package com.openapi.blogsearch.search.exception;

public interface SearchClientExceptionHandler {

    RuntimeException translatorExceptionIfPossible(Exception exception);

}
