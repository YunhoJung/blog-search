package com.openapi.blogsearch.application.search.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.openapi.blogsearch.domain.search.InvalidKeywordException;
import com.openapi.blogsearch.domain.search.Search;
import com.openapi.blogsearch.domain.search.SearchRepository;
import com.openapi.blogsearch.search.SearchBlogClient;
import com.openapi.blogsearch.search.dto.BlogResultDto;
import com.openapi.blogsearch.search.dto.SearchResultDto;
import com.openapi.blogsearch.search.dto.SearchResultInfoDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetSearchServiceTest {

    private SearchRepository searchRepository = mock(SearchRepository.class);

    private SearchBlogClient searchBlogClient = mock(SearchBlogClient.class);

    private GetSearchService getSearchService;

    private SearchResultInfoDto searchResultInfoDto;
    private BlogResultDto blogResultDto;
    private List<BlogResultDto> blogResultDtoList = new ArrayList<>();

    private String validKeyword;
    private String invalidNullKeyword;
    private String invalidBlankKeyword;


    private String sort;

    private int page;

    private int size;

    private int totalCount;

    private int pageableCount;

    private String title;

    private String contents;

    private String url;

    private LocalDateTime postedAt;


    @BeforeEach
    void init() {
        getSearchService = new GetSearchService(searchRepository, searchBlogClient);

        validKeyword = "keyword";
        invalidNullKeyword = null;
        invalidBlankKeyword = "";

        sort = "accuracy";

        page = 1;

        size = 10;

        totalCount = 1;

        pageableCount = 10;

        title = "title";

        contents = "contents";

        url = "www.example.com";

        postedAt = LocalDateTime.now();

    }

    @Test
    void getSearchResultTest() {
        given(searchRepository.save(any(Search.class))).willReturn(search());

        given(searchBlogClient.search(any(String.class), any(String.class),
            any(int.class), any(int.class))).willReturn(searchResultDto());

        getSearchService.getSearchResult(validKeyword, sort, page, size);

        verify(searchRepository).save(any(Search.class));
        verify(searchBlogClient, atLeastOnce())
            .search(any(String.class), any(String.class),
                any(int.class), any(int.class));
    }

    @Test
    void invalidNullKeywordTest() {
        assertThatThrownBy(() -> getSearchService
            .getSearchResult(invalidNullKeyword, sort, page, size))
            .isInstanceOf(InvalidKeywordException.class);
    }

    @Test
    void invalidBlankKeywordTest() {
        assertThatThrownBy(() -> getSearchService
            .getSearchResult(invalidBlankKeyword, sort, page, size))
            .isInstanceOf(InvalidKeywordException.class);
    }

    SearchResultDto searchResultDto() {
        searchResultInfoDto = new SearchResultInfoDto(totalCount, pageableCount);
        blogResultDto = new BlogResultDto(title, contents, url, postedAt);
        blogResultDtoList.add(blogResultDto);

        return new SearchResultDto(searchResultInfoDto, blogResultDtoList);
    }

    Search search() {
        return Search.createSearch(validKeyword);
    }

}