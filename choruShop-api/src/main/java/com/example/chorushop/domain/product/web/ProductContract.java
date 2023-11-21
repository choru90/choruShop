package com.example.chorushop.domain.product.web;

import com.example.chorushop.dto.ProductReq;
import com.example.chorushop.dto.ProductRes;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = " 상품 API", description = "상품 등록, 조회, 삭제, 수정 API")
public interface ProductContract {

    Long create(Long companyId, ProductReq req);

    ProductRes update(Long id, ProductReq req);
    void delete(Long id);

    ProductRes get(Long id);

    List<ProductRes> getList(Long companyId);


}
