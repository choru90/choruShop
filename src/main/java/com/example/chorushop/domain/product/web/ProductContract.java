package com.example.chorushop.domain.product.web;

import com.example.chorushop.domain.product.dto.ProductReq;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = " 상품 API", description = "상품 등록, 조회, 삭제, 수정 API")
public interface ProductContract {

    Long create(Long companyId,ProductReq req);


}
