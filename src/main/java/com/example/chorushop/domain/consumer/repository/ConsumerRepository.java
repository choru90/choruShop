package com.example.chorushop.domain.consumer.repository;

import com.example.chorushop.domain.consumer.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

    boolean existsByEmail(String email);

    boolean existsByLoginId(String loginId);
}
