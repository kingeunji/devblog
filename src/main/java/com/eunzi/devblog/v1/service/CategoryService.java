package com.eunzi.devblog.v1.service;

import com.eunzi.devblog.entity.Category;
import com.eunzi.devblog.repository.CategoryRepository;
import com.eunzi.devblog.v1.api.request.CategoryRequest;
import com.eunzi.devblog.v1.api.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponse registerCategory(CategoryRequest request) {
        Category category = Category.create(request);
        category = categoryRepository.save(category);
        CategoryResponse response = new CategoryResponse(category);
        return response;
    }

    public Page<CategoryResponse> getCategorys(Pageable pageable) {
        Page<Category> categorys = categoryRepository.findAll(pageable);
        return categorys.map(CategoryResponse::new);
    }

}
