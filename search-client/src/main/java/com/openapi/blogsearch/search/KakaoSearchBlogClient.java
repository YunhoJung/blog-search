package com.openapi.blogsearch.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openapi.blogsearch.search.dto.KakaoBlog;
import com.openapi.blogsearch.search.dto.SearchResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
@RequiredArgsConstructor
public class KakaoSearchBlogClient {

    private final SearchBlogConfig searchBlogConfig;
    private final ObjectMapper mapper;

    public SearchResultDto search(String keyword, String sort, int page, int size) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + searchBlogConfig.getKey());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(searchBlogConfig.getUrl())
            .queryParam("query", keyword)
            .queryParam("sort", sort)
            .queryParam("page", page)
            .queryParam("size", size);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        String body = restTemplate
            .exchange(builder.toUriString(), HttpMethod.GET, entity, String.class)
            .getBody();

        KakaoBlog kakaoBlog = null;
        try {
            kakaoBlog = mapper.readValue(body, KakaoBlog.class);
        } catch (JsonProcessingException e) {
            log.info("JsonProcessingException");
        }

        return SearchResultDto.fromKakaoBlog(kakaoBlog);

    }
}
