package com.openapi.blogsearch.application.search.service;

import static java.util.stream.Collectors.toList;

import com.openapi.blogsearch.application.search.port.GetKeywordUseCase;
import com.openapi.blogsearch.application.search.port.dto.KeywordData;
import com.openapi.blogsearch.domain.search.SearchRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetKeywordService implements GetKeywordUseCase {

    private final SearchRepository searchRepository;

    @Override
    public List<KeywordData> getTop10Keywords() {

        return searchRepository
                .findTop10KeywordsBySearchCount()
            .stream()
            .map(KeywordData::from)
            .collect(toList());
    }
}
