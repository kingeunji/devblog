package com.eunzi.devblog.entity;

import com.eunzi.devblog.v1.api.request.PostRequest;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column
    private String title;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private String content;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "view_cnt")
    private Integer viewCnt;

    public static Post create(PostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCategory(request.getCategory());
        return post;
    }

}
