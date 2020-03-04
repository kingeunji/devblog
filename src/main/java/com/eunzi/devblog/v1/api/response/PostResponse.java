package com.eunzi.devblog.v1.api.response;

import com.eunzi.devblog.entity.Category;
import com.eunzi.devblog.entity.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {
    private Long postId;
    private String title;
    private String content;
    private Category category;
    private LocalDateTime createdDate;
    private Integer viewCnt;

    public PostResponse(Post post) {
        this.setPostId(post.getPostId());
        this.setTitle(post.getTitle());
        this.setContent(post.getContent());
        this.setCategory(post.getCategory());
        this.setCreatedDate(post.getCreatedDate());
        this.setViewCnt(post.getViewCnt());
    }
}
