package com.openapi.blogsearch.interfaces.search.web;

import com.openapi.blogsearch.application.search.port.dto.SearchData;
import com.openapi.blogsearch.application.search.service.GetSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetSearchController {

    private final GetSearchService getSearchService;

    @GetMapping("/search")
    public ResponseEntity<SearchData> listSearchResult(
        @RequestParam String query,
        @RequestParam(defaultValue = "accuracy") String sort,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(getSearchService
                .getSearchResult(query, sort, page, size));
    }

}
