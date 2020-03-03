package com.eunzi.devblog.v1.service;

import com.eunzi.devblog.entity.Post;
import com.eunzi.devblog.repository.PostRepository;
import com.eunzi.devblog.v1.api.request.PostRequest;
import com.eunzi.devblog.v1.api.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public PostResponse registerPost(PostRequest request) {
        Post post = Post.create(request);
        post = postRepository.save(post);
        PostResponse response = new PostResponse(post);
        return response;
    }

    public Page<PostResponse> getPosts(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        return posts.map(PostResponse::new);
    }

}
