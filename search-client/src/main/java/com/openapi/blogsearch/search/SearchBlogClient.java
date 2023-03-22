package com.openapi.blogsearch.search;

import com.openapi.blogsearch.search.dto.SearchResultDto;

public interface SearchBlogClient {

    public SearchResultDto search(String keyword, String sort, int page, int size);

}
