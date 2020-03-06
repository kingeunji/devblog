package com.eunzi.devblog.v1.api;

import com.eunzi.devblog.entity.Category;
import com.eunzi.devblog.entity.Post;
import com.eunzi.devblog.v1.api.request.PostRequest;
import com.eunzi.devblog.v1.api.response.PostResponse;
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
public class PostApiTest {

    @Autowired
    PostService postService;

    @Test
    public void registerPostTest() {
        Category category = new Category();
        category.setName("테스트");

        PostRequest request = new PostRequest();
        request.setTitle("테스트 포스트");
        request.setContent("음음음 음음음");
        request.setCategory(category);

        PostResponse response = postService.registerPost(request);

        assertThat(response.getTitle(), is("테스트 포스트"));

    }

    @Test
    public void postDetailTest() {
        Long postId = 9l;
        PostResponse postResponse = postService.getPostDetail(postId);
        assertThat(postResponse.getPostId(), is(9l));
    }

}