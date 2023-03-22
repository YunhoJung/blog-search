package com.openapi.blogsearch.interfaces.search.web;

import com.openapi.blogsearch.application.search.port.dto.KeywordData;
import com.openapi.blogsearch.application.search.service.GetKeywordService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetKeywordController {

    private final GetKeywordService getKeywordService;

    @GetMapping("/keyword")
    public ResponseEntity<List<KeywordData>> listTop10Keywords() {
        return ResponseEntity
            .ok(getKeywordService.getTop10Keywords());
    }
}
