package com.eunzi.devblog.repository;

import com.eunzi.devblog.entity.Category;
import com.eunzi.devblog.entity.Post;
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
public class PostRepositoryTest  {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void create() {
        Category category = new Category();
        category.setName("개발");

        categoryRepository.save(category);

        Post post = new Post();
        post.setTitle("첫번째 테스트");
        post.setCategory(category);
        post.setContent("안녕 안녕 안녕하세요");

        Post savePost = postRepository.save(post);
        assertThat(savePost.getTitle(), is("첫번째 테스트"));

    }
}
