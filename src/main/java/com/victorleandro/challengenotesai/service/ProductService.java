package com.victorleandro.challengenotesai.service;


import com.victorleandro.challengenotesai.controller.ProductDTO;
import com.victorleandro.challengenotesai.entity.Category;
import com.victorleandro.challengenotesai.entity.Product;
import com.victorleandro.challengenotesai.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    public Product save(ProductDTO productData) throws Exception {
        Category category = categoryService.categoryFindById(productData.id())
                .orElseThrow(NotFoundException::new);
        return productRepository
                .save(Product.builder()
                        .ownerId(productData.ownerId())
                        .price(productData.price())
                        .title(productData.title())
                        .description(productData.description())
                        .category(category)
                        .build());
    }

    public List<Product> productList() {
        return productRepository.findAll();
    }

    public Product replace(String id, ProductDTO productDTO) throws NotFoundException {
        Category category = categoryService.categoryFindById(id).orElseThrow(NotFoundException::new);
        Product product = productRepository.findById(id).orElseThrow(NotFoundException::new);
        Product responseSave = Product.builder()
                .id(product.getId())
                .description(!productDTO.description().isEmpty() ? productDTO.description() : category.getDescription())
                .title(!productDTO.title().isEmpty() ? productDTO.title() : category.getTitle())
                .price(product.getPrice())
                .category(category)
                .ownerId(!productDTO.ownerId().isEmpty() ? productDTO.ownerId() : product.getOwnerId())
                .build();
        return productRepository.save(responseSave);
    }


    public void delete(String id) throws NotFoundException {
        Product byId = productRepository.findById(id).orElseThrow(NotFoundException::new);
        productRepository.delete(byId);
    }
}