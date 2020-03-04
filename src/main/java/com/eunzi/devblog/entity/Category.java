package com.eunzi.devblog.entity;

import com.eunzi.devblog.v1.api.request.CategoryRequest;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column
    private String name;

    public static Category create(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }
}
