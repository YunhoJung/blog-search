package com.openapi.blogsearch.application.search.port.dto;

import com.openapi.blogsearch.search.dto.BlogResultDto;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlogDto {

    private String title;

    private String contents;

    private String url;

    private LocalDateTime postedAt;

    public static BlogDto from(BlogResultDto blogResultDto) {
        return new BlogDto(
            blogResultDto.getTitle(),
            blogResultDto.getContents(),
            blogResultDto.getUrl(),
            blogResultDto.getPostedAt()
        );
    }


}
