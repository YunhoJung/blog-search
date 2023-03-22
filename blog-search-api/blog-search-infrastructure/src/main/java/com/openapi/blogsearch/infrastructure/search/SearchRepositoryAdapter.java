package com.openapi.blogsearch.infrastructure.search;

import com.openapi.blogsearch.domain.search.Search;
import com.openapi.blogsearch.domain.search.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchRepositoryAdapter implements SearchRepository {

    private final JpaSearchRepository jpaSearchRepository;

    @Override
    public Search save(Search search) {
        return jpaSearchRepository.save(search);
    }
}
