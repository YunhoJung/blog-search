package com.openapi.blogsearch.infrastructure.search;

import com.openapi.blogsearch.domain.search.KeywordDto;
import com.openapi.blogsearch.domain.search.Search;
import com.openapi.blogsearch.domain.search.SearchRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchRepositoryAdapter implements SearchRepository {

    private final JpaSearchRepository jpaSearchRepository;

    @Override
    public Search save(Search search) {
        return jpaSearchRepository.save(search);
    }

    @Override
    public List<KeywordDto> findTop10KeywordsBySearchCount() {
        PageRequest page = PageRequest.of(0, 10);

        return jpaSearchRepository.findTop10KeywordsBySearchCount(page);
    }
}
