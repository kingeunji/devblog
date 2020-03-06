package com.eunzi.devblog.v1.api.response;

import com.eunzi.devblog.entity.Category;
import lombok.Data;

@Data
public class CategoryResponse {
    private Long categoryId;
    private String name;

    public CategoryResponse(Category category) {
        this.setCategoryId(category.getCategoryId());
        this.setName(category.getName());
    }
}
