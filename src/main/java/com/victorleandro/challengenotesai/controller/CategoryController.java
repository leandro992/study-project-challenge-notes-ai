package com.victorleandro.challengenotesai.controller;

import com.victorleandro.challengenotesai.entity.Category;
import com.victorleandro.challengenotesai.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

   private final CategoryService categoryService;
    @PostMapping
    public ResponseEntity<Category> save(@RequestBody CategoryDTO request){

       return ResponseEntity.ok(categoryService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(categoryService.categoryList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> replace(@PathVariable("id") String id, @RequestBody CategoryDTO request) throws Exception {
        return ResponseEntity.ok(categoryService.categoryReplace(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception {
        categoryService.categoryDelete(id);
        return ResponseEntity.noContent().build();
    }
}
