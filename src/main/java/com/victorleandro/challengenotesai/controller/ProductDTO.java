package com.victorleandro.challengenotesai.controller;

import lombok.Builder;

@Builder
public record ProductDTO(
        String id,
        String title,
        String ownerId,
        Integer price,
        String description) {
}