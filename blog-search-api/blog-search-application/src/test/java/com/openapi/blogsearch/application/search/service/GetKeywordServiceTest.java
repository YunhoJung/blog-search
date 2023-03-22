package com.openapi.blogsearch.application.search.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

import com.openapi.blogsearch.domain.search.KeywordDto;
import com.openapi.blogsearch.domain.search.SearchRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetKeywordServiceTest {

    private SearchRepository searchRepository = mock(SearchRepository.class);

    private GetKeywordService getKeywordService = mock(GetKeywordService.class);

    private String keyword;
    private Long count;
    private KeywordDto keywordDto;
    private List<KeywordDto> keywordDtoList = new ArrayList<>();


    @BeforeEach
    void init() {
        getKeywordService = new GetKeywordService(searchRepository);

        keyword = "keyword";
        count = 1L;
    }

    @Test
    void getTop10KeywordsTest() {
        given(searchRepository.findTop10KeywordsBySearchCount()).willReturn(keywordDtoList());
    }

    List<KeywordDto> keywordDtoList() {
        keywordDto = new KeywordDto(keyword, count);
        keywordDtoList.add(keywordDto);
        return keywordDtoList;
    }

}