package com.example.chorushop.service;



import com.example.chorushop.dto.ProductReq;
import com.example.chorushop.dto.ProductRes;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    Long create(Long companyId, ProductReq req);

    ProductRes update(Long id, ProductReq req);

    void delete(Long id);

    ProductRes get(Long id);

    List<ProductRes> getList(Long companyId);
}
