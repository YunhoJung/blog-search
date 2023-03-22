package com.openapi.blogsearch.search.dto;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchResultDto {

    private SearchResultInfoDto searchResultInfoDto;
    private List<BlogResultDto> blogResultDtoList = new ArrayList<>();

    public static SearchResultDto fromKakaoBlog(KakaoBlog kakaoBlog) {
        return new SearchResultDto(
            SearchResultInfoDto.from(kakaoBlog.getMeta()),
            kakaoBlog.getDocuments().stream()
                .map(BlogResultDto::from)
                .collect(toList())
        );
    }

}
