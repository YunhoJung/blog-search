package com.openapi.blogsearch.search.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentResult {

    private String title;

    private String contents;

    private String url;

    private String blogName;

    private String thumbnail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSz", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSz")
    private LocalDateTime datetime;

}
