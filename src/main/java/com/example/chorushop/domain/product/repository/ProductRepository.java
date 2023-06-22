package com.example.chorushop.domain.product.repository;

import com.example.chorushop.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
