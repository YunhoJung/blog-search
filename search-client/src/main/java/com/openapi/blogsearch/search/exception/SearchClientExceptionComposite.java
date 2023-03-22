package com.openapi.blogsearch.search.exception;

import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SearchClientExceptionComposite implements SearchClientExceptionHandler {

    private static final List<SearchClientExceptionHandler> delegates =
        new ArrayList<>(5);

    static {
        delegates.add(new HttpClientErrorExceptionTranslator());
        delegates.add(new HttpServerErrorExceptionTranslator());
        delegates.add(new RuntimeExceptionTranslator());
        delegates.add(new ExceptionTranslator());
    }

    @AfterThrowing(pointcut = "within(@SearchClientExceptionAspect *)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) throws Throwable {
        throw translatorExceptionIfPossible(ex);
    }

    @Override
    public RuntimeException translatorExceptionIfPossible(Exception ex) {
        for (SearchClientExceptionHandler handler : this.delegates) {
            RuntimeException translatedException = handler.translatorExceptionIfPossible(ex);
            if (translatedException != null) {
                return translatedException;
            }
        }
        return new RuntimeException(ex.getMessage());
    }
}
