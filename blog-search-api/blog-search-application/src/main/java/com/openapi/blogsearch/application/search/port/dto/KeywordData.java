package com.openapi.blogsearch.application.search.port.dto;

import com.openapi.blogsearch.domain.search.KeywordDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KeywordData {

    private String keyword;

    private Long count;

    public static KeywordData from(KeywordDto keywordDto) {
        return new KeywordData(
            keywordDto.getKeyword(),
            keywordDto.getCount()
        );
    }



}
