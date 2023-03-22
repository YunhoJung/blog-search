package com.openapi.blogsearch.search.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Meta {

    private int totalCount;

    private int pageableCount;

    private int isEnd;

}
