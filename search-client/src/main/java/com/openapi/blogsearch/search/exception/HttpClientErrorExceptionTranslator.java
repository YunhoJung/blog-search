package com.openapi.blogsearch.search.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpClientErrorException;

@RequiredArgsConstructor
public class HttpClientErrorExceptionTranslator implements SearchClientExceptionHandler {

    @Override
    public RuntimeException translatorExceptionIfPossible(Exception exception) {
        if (exception instanceof HttpClientErrorException) {
            HttpClientErrorException httpClientErrorException = (HttpClientErrorException) exception;

            if ("400".equals(String.valueOf(httpClientErrorException.getStatusCode()).substring(0,3))) {
                return new InvalidArgumentException(httpClientErrorException.getMessage());
            }
        }

        return null;
    }
}
