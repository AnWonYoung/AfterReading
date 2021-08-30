package com.wonyoung.afterreading.board;

import lombok.Getter;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString

public class CrawlEntity {
    private String bookCover;
    private String author;
    private String title;
}
