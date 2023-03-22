package com.openapi.blogsearch.infrastructure.search;

import com.openapi.blogsearch.domain.search.KeywordDto;
import com.openapi.blogsearch.domain.search.Search;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaSearchRepository extends JpaRepository<Search, Long> {

    @Query(
        "SELECT "
        + "new com.openapi.blogsearch.domain.search.KeywordDto(s.keyword, count(s.keyword)) "
        + "FROM Search s "
        + "GROUP BY s.keyword "
        + "ORDER BY count(s.keyword) DESC "
    )
    List<KeywordDto> findTop10KeywordsBySearchCount(Pageable pageable);
}
