package com.openapi.blogsearch.application.search.port;

import com.openapi.blogsearch.application.search.port.dto.SearchData;

public interface GetSearchUseCase {

    SearchData getSearchResult(String keyword, String sort, int page, int size);

}
