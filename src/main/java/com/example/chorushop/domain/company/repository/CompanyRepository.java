package com.example.chorushop.domain.company.repository;

import com.example.chorushop.domain.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
