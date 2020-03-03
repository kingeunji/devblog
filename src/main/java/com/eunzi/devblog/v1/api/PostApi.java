package com.eunzi.devblog.v1.api;

import com.eunzi.devblog.v1.api.request.PostRequest;
import com.eunzi.devblog.v1.api.response.PostResponse;
import com.eunzi.devblog.v1.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
