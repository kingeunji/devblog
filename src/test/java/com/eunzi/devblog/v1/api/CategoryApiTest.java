package com.eunzi.devblog.v1.api;

import com.eunzi.devblog.entity.Category;
import com.eunzi.devblog.entity.Post;
import com.eunzi.devblog.v1.api.request.CategoryRequest;
import com.eunzi.devblog.v1.api.request.PostRequest;
import com.eunzi.devblog.v1.api.response.CategoryResponse;
import com.eunzi.devblog.v1.api.response.PostResponse;
import com.eunzi.devblog.v1.service.CategoryService;
import com.eunzi.devblog.v1.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryApiTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void registerCategoryTest() {
        CategoryRequest request = new CategoryRequest();
        request.setName("일상");
        CategoryResponse response = categoryService.registerCategory(request);

        assertThat(response.getName(), is("일상"));

    }

}