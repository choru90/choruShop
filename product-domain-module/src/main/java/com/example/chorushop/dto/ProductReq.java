package com.example.chorushop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record ProductReq(
        @Schema(description = "상품명" ) @NotNull String name,
        @Schema(description = "가격") @NotNull Integer price,
        @Schema(description = "카테고리") @NotNull String category
) {


}
