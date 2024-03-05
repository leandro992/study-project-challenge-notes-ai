package com.victorleandro.desafioanotaai.repository;

import com.victorleandro.desafioanotaai.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
