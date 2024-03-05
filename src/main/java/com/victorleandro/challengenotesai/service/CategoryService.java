package com.victorleandro.challengenotesai.service;

import com.victorleandro.challengenotesai.controller.CategoryDTO;
import com.victorleandro.challengenotesai.entity.Category;
import com.victorleandro.challengenotesai.repository.CategoryRepository;
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
