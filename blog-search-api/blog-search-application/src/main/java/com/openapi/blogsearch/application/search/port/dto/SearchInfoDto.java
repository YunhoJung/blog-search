package com.openapi.blogsearch.application.search.port.dto;

import com.openapi.blogsearch.search.dto.Meta;
import com.openapi.blogsearch.search.dto.SearchResultInfoDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchInfoDto {

    private int totalCount;

    private int pageableCount;

    public static SearchInfoDto from(SearchResultInfoDto searchResultInfoDto) {
        return new SearchInfoDto(
            searchResultInfoDto.getTotalCount(),
            searchResultInfoDto.getPageableCount()
        );
    }

}
