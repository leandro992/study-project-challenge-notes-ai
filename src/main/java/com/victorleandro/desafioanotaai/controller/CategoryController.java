package com.victorleandro.desafioanotaai.controller;

import com.victorleandro.desafioanotaai.entity.Category;
import com.victorleandro.desafioanotaai.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

   private final CategoryService categoryService;
    @PostMapping
    public ResponseEntity<Category> save(@RequestBody CategoryDTO request){
       return ResponseEntity.ok(categoryService.save(request));

    }


}