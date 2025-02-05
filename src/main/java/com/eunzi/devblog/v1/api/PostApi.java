package com.eunzi.devblog.v1.api;

import com.eunzi.devblog.v1.api.request.PostRequest;
import com.eunzi.devblog.v1.api.response.PostResponse;
import com.eunzi.devblog.v1.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/api/")
public class PostApi {

    @Autowired
    PostService postService;

    // POST /posts
    @PostMapping("/posts")
    public ResponseEntity<PostResponse> registerPost(@RequestBody PostRequest request) {
        if(StringUtils.isEmpty(request.getTitle()) || StringUtils.isEmpty(request.getContent())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            PostResponse response = postService.registerPost(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    // GET /posts
    @GetMapping("/posts")
    public ResponseEntity<Page<PostResponse>> postList(Pageable pageable) {
        Page<PostResponse> postResponses = postService.getPosts(pageable);
        return new ResponseEntity<>(postResponses, HttpStatus.OK);
    }

    // GET /post/{id}
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostResponse> getPostDetail(@PathVariable Long postId) {
        PostResponse postResponse = postService.getPostDetail(postId);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }


}
