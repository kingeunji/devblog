package com.eunzi.devblog.v1.api;

import com.eunzi.devblog.entity.Category;
import com.eunzi.devblog.v1.api.request.CategoryRequest;
import com.eunzi.devblog.v1.api.response.CategoryResponse;
import com.eunzi.devblog.v1.api.response.PostResponse;
import com.eunzi.devblog.v1.service.CategoryService;
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
public class CategoryApi {

    @Autowired
    CategoryService categoryService;

    // POST /categorys
    @PostMapping("/categorys")
    public ResponseEntity<CategoryResponse> registerCategory(@RequestBody CategoryRequest request) {
        if(StringUtils.isEmpty(request.getName())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            CategoryResponse response = categoryService.registerCategory(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    // GET /categorys
    @GetMapping("/categorys")
    public ResponseEntity<Page<CategoryResponse>> categoryList(Pageable pageable) {
        Page<CategoryResponse> categoryResponses = categoryService.getCategorys(pageable);
        return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
    }

}
