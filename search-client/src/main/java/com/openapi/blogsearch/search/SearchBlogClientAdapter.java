package com.openapi.blogsearch.search;

import com.openapi.blogsearch.search.dto.SearchResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchBlogClientAdapter implements SearchBlogClient {

    private final KakaoSearchBlogClient kakaoSearchBlogClient;

    @Override
    public SearchResultDto search(String keyword, String sort, int page, int size) {
        return kakaoSearchBlogClient.search(keyword, sort, page, size);
    }
}
