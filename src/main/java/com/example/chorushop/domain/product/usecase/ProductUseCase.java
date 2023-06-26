package com.example.chorushop.domain.product.usecase;

import com.example.chorushop.domain.company.dto.CompanyRes;
import com.example.chorushop.domain.company.service.CompanyService;
import com.example.chorushop.domain.product.dto.ProductReq;
import com.example.chorushop.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductService service;
    private final CompanyService companyService;


    /* 상품 등록
    * 1. company id 값으로 company 정보를 불러온다
    * 2. Request Product 값으로 ProductEntity 생성
    * 3. 등록된 Product ID 반환
    * */
    @Transactional
    public Long creatProduct(Long companyId, ProductReq req){
        CompanyRes companyRes = companyService.get(companyId);
        return service.create(companyRes.id(), req);
    }
}

