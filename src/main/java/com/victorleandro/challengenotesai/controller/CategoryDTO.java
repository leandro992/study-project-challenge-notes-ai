package com.victorleandro.challengenotesai.controller;

import lombok.Builder;

@Builder
public record CategoryDTO(
        String title,
        String description,
        String ownerId) {
}
