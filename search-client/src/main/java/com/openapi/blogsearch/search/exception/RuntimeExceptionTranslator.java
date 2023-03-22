package com.openapi.blogsearch.search.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RuntimeExceptionTranslator implements SearchClientExceptionHandler {

    @Override
    public RuntimeException translatorExceptionIfPossible(Exception exception) {
        return null;
    }
}
