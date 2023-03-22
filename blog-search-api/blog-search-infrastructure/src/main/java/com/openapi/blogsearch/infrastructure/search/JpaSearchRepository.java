package com.openapi.blogsearch.infrastructure.search;

import com.openapi.blogsearch.domain.search.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSearchRepository extends JpaRepository<Search, Long> {

}
