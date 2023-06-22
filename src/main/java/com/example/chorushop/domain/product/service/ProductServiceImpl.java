package com.example.chorushop.domain.product.service;

import com.example.chorushop.domain.company.entity.Company;
import com.example.chorushop.domain.product.dto.ProductReq;
import com.example.chorushop.domain.product.dto.ProductRes;
import com.example.chorushop.domain.product.entity.Product;
import com.example.chorushop.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    @Override
    public Long create(Company company, ProductReq req) {
        Product product = new Product(req.name(), req.price(), req.category(), company);
        return repository.save(product).getId();
    }

    @Override
    public ProductRes update(Long id, ProductReq req) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductRes get(Long id) {
        return null;
    }

    @Override
    public List<ProductRes> getList() {
        return null;
    }
}
