package com.example.chorushop.domain.product.service;

import com.example.chorushop.domain.product.dto.ProductReq;
import com.example.chorushop.domain.product.dto.ProductRes;

import java.util.List;

public interface ProductService {

    Long create(Long companyId, ProductReq req);

    ProductRes update(Long id, ProductReq req);

    void delete(Long id);

    ProductRes get(Long id);

    List<ProductRes> getList();
}
