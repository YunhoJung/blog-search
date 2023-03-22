package com.openapi.blogsearch.search.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KakaoBlog {

    private List<DocumentResult> documents;

    private Meta meta;

}
