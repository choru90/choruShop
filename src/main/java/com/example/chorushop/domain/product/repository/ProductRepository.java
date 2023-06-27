package com.example.chorushop.domain.product.repository;

import com.example.chorushop.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCompanyId(Long companyId);
}
