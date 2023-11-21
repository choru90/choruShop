package com.example.chorushop.service;

import com.example.chorushop.dto.ProductReq;
import com.example.chorushop.dto.ProductRes;
import com.example.chorushop.entity.Product;
import com.example.chorushop.exception.RestApiException;
import com.example.chorushop.exception.RestApiExceptionCode;
import com.example.chorushop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    @Override
    public Long create(Long companyId, ProductReq req) {
        Product product = new Product(req.name(), req.price(), req.category(), companyId);
        return repository.save(product).getId();
    }

    @Override
    @Transactional
    public ProductRes update(Long id, ProductReq req) {
        Product product = getProductById(id);
        product.update(req.name(), req.price(), req.category());
        return getProductRes(product);
    }

    @Override
    public void delete(Long id) {
        Product product = getProductById(id);
        repository.delete(product);
    }

    @Override
    public ProductRes get(Long id) {
        Product product = getProductById(id);
        return getProductRes(product);
    }

    @Override
    public List<ProductRes> getList(Long companyId) {
        List<Product> products = getListByCompanyId(companyId);
        return products.stream()
                       .map(product -> getProductRes(product))
                       .toList();
    }
    private Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestApiException(RestApiExceptionCode.NOT_FOUND, "상품 정보가 없습니다."));
    }

    private List<Product> getListByCompanyId(Long companyId){
        List<Product> products = repository.findAllByCompanyId(companyId);
        if(ObjectUtils.isEmpty(products)){
            throw new RestApiException(RestApiExceptionCode.NOT_FOUND, "상품 목록이 없습니다.");
        }
        return products;
    }

    private ProductRes getProductRes(Product product) {
        return new ProductRes(product.getId(), product.getName(), product.getPrice(), product.getCategory(), product.getCompanyId());
    }

}
