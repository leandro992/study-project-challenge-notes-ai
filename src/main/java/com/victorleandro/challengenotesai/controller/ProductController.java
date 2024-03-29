package com.victorleandro.challengenotesai.controller;

import com.victorleandro.challengenotesai.entity.Product;
import com.victorleandro.challengenotesai.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
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
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDTO request) throws Exception {

        return ResponseEntity.ok(productService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.productList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replace(@PathVariable("id") String id, @RequestBody ProductDTO request) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(productService.replace(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}