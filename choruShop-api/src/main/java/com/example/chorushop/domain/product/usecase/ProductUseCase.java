package com.example.chorushop.domain.product.usecase;

import com.example.chorushop.domain.company.dto.CompanyRes;
import com.example.chorushop.domain.company.service.CompanyService;
import com.example.chorushop.dto.ProductReq;
import com.example.chorushop.dto.ProductRes;
import com.example.chorushop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductService service;
    private final CompanyService companyService;


    @Transactional
    public Long creatProduct(Long companyId, ProductReq req){
        CompanyRes companyRes = companyService.get(companyId);
        return service.create(companyRes.id(), req);
    }

    public ProductRes get(Long id){
        return service.get(id);
    }

    public List<ProductRes> getList(Long companyId){
        return service.getList(companyId);
    }

    public ProductRes update(Long id, ProductReq req){
        return service.update(id, req);
    }

    public void delete(Long id){
        service.delete(id);
    }
}

