package com.victorleandro.challengenotesai.repository;

import com.victorleandro.challengenotesai.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
