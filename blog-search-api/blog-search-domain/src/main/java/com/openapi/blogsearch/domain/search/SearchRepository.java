package com.openapi.blogsearch.domain.search;

import java.util.List;
import org.springframework.data.domain.Pageable;

public interface SearchRepository {

    Search save(Search search);

    List<KeywordDto> findTop10KeywordsBySearchCount();

}
