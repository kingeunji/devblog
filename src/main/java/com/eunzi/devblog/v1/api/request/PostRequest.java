package com.eunzi.devblog.v1.api.request;

import com.eunzi.devblog.entity.Category;
import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String content;
    private Category category;
}
