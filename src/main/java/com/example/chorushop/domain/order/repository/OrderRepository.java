package com.example.chorushop.domain.order.repository;

import com.example.chorushop.domain.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
