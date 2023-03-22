package com.openapi.blogsearch.search;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "external.api")
public class SearchBlogConfig {

    private final String url;

    private final String key;

}
