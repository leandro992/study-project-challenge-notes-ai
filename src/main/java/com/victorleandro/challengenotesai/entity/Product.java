package com.victorleandro.challengenotesai.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String title;
    private String ownerId;
    private Integer price;
    private String description;
    private Category category;
}
