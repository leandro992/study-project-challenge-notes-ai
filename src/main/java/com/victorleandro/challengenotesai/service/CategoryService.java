package com.victorleandro.challengenotesai.service;

import com.victorleandro.challengenotesai.controller.CategoryDTO;
import com.victorleandro.challengenotesai.entity.Category;
import com.victorleandro.challengenotesai.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category save(CategoryDTO categoryDTO) {

        return categoryRepository
                .save(Category.builder()
                        .ownerId(categoryDTO.ownerId())
                        .title(categoryDTO.title())
                        .description(categoryDTO.description())
                        .build());
    }

    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }


    public Optional<Category> categoryFindById(String id) {
        return categoryRepository.findById(id);
    }

    public Category categoryReplace(String id, CategoryDTO categoryDTO) throws NotFoundException {
        Category byId = categoryRepository.findById(id).orElseThrow(NotFoundException::new);
        Category responseSave = Category.builder()
                .id(byId.getId())
                .description(!categoryDTO.description().isEmpty() ? categoryDTO.description() : byId.getDescription())
                .title(!categoryDTO.title().isEmpty() ? categoryDTO.title() : byId.getTitle())
                .ownerId(!categoryDTO.title().isEmpty() ? categoryDTO.ownerId(): byId.getOwnerId())
                .build();
        return categoryRepository.save(responseSave);
    }

    public void categoryDelete(String id) throws NotFoundException {
        Category byId = categoryRepository.findById(id).orElseThrow(NotFoundException::new);
        categoryRepository.delete(byId);
    }
}
