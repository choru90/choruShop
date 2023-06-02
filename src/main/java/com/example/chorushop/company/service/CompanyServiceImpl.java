package com.example.chorushop.company.service;

import com.example.chorushop.company.dto.CompanyReq;
import com.example.chorushop.company.dto.CompanyRes;
import com.example.chorushop.company.entity.Company;
import com.example.chorushop.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository repository;
    @Override
    public Long create(CompanyReq req) {
        Company company = repository.save(
                Company.builder()
                        .companyName(req.getCompanyName())
                        .companyNum(req.getCompanyNum())
                        .representative(req.getRepresentative())
                        .address(req.getAddress())
                        .bizType(req.getBizType()).build()
        );

        return company.getId();
    }

    @Override
    public CompanyRes update(CompanyReq req) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CompanyRes get(Long id) {
        return null;
    }

    @Override
    public List<CompanyRes> getList() {
        return null;
    }
}
