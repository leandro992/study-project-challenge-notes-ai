package com.victorleandro.desafioanotaai.service;

import com.victorleandro.desafioanotaai.controller.CategoryDTO;
import com.victorleandro.desafioanotaai.entity.Category;
import com.victorleandro.desafioanotaai.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category save(CategoryDTO categoryDTO){
       return categoryRepository
               .save(Category.builder()
                       .ownerId(categoryDTO.ownerId())
                       .title(categoryDTO.title())
                       .description(categoryDTO.description())
                       .build());
    }

}
