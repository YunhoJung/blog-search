package com.openapi.blogsearch.application.search.service;

import com.openapi.blogsearch.application.search.port.GetSearchUseCase;
import com.openapi.blogsearch.application.search.port.dto.SearchData;
import com.openapi.blogsearch.domain.search.Search;
import com.openapi.blogsearch.domain.search.SearchRepository;
import com.openapi.blogsearch.search.SearchBlogClient;
import com.openapi.blogsearch.search.dto.SearchResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetSearchService implements GetSearchUseCase {

    private final SearchRepository searchRepository;

    private final SearchBlogClient searchBlogClient;

    @Transactional
    @Override
    public SearchData getSearchResult(String keyword, String sort, int page, int size) {
        Search.validateKeyword(keyword);

        SearchResultDto searchResultDto = searchBlogClient
            .search(keyword, sort, page, size);

        searchRepository.save(
            Search.createSearch(keyword)
        );

        return SearchData.from(searchResultDto);
    }
}
