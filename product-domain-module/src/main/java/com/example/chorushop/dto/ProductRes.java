package com.example.chorushop.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ProductRes(
        @Schema(description = "상품 ID") Long id,
        @Schema(description = "상품명") String name,
        @Schema(description = "가격") Integer price,
        @Schema(description = "카테고리") String category,
        @Schema(description = "회사 ID") Long companyId
) {
}
