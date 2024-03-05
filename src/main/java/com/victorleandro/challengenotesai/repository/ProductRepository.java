package com.victorleandro.challengenotesai.repository;

import com.victorleandro.challengenotesai.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
