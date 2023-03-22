package com.openapi.blogsearch.search.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlogResultDto {

    private String title;

    private String contents;

    private String url;

    private LocalDateTime postedAt;

    public static BlogResultDto from(DocumentResult document) {
        return new BlogResultDto(
            document.getTitle(),
            document.getContents(),
            document.getUrl(),
            document.getDatetime()
        );
    }
}
