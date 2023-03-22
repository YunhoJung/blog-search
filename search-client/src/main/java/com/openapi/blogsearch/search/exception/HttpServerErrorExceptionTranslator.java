package com.openapi.blogsearch.search.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpServerErrorException;

@RequiredArgsConstructor
public class HttpServerErrorExceptionTranslator implements SearchClientExceptionHandler {

    @Override
    public RuntimeException translatorExceptionIfPossible(Exception exception) {
        if (exception instanceof HttpServerErrorException) {
            HttpServerErrorException httpServerErrorException = (HttpServerErrorException) exception;

            if ("500".equals(String.valueOf(httpServerErrorException.getStatusCode()).substring(0,3))) {
                return new InternalServerErrorException(httpServerErrorException.getMessage());
            }
        }
        return null;
    }
}
