package com.openapi.blogsearch.application.search.port.dto;

import static java.util.stream.Collectors.toList;

import com.openapi.blogsearch.search.dto.SearchResultDto;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchData {

    private SearchInfoDto searchInfoDto;
    private List<BlogDto> blogDtoList = new ArrayList<>();

    public static SearchData from(SearchResultDto searchResultDto) {
        return new SearchData(
            SearchInfoDto.from(searchResultDto.getSearchResultInfoDto()),
            searchResultDto.getBlogResultDtoList().stream()
                .map(BlogDto::from)
                .collect(toList())
        );
    }

}
