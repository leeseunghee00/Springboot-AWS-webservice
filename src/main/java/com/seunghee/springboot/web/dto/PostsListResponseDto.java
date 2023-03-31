package com.seunghee.springboot.web.dto;

import com.seunghee.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts enitty) {
        this.id =  enitty.getId();
        this.title =  enitty.getTitle();
        this.author =  enitty.getAuthor();
        this.modifiedDate =  enitty.getModifiedDate();
    }

}
