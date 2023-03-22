package com.openapi.blogsearch.search.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchResultInfoDto {

    private int totalCount;

    private int pageableCount;

    public static SearchResultInfoDto from(Meta meta) {
        return new SearchResultInfoDto(
            meta.getTotalCount(),
            meta.getPageableCount()
        );
    }

}
