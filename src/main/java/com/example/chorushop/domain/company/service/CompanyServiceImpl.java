package com.example.chorushop.domain.company.service;

import com.example.chorushop.common.exception.RestApiException;
import com.example.chorushop.common.exception.RestApiExceptionCode;
import com.example.chorushop.domain.company.dto.CompanyReq;
import com.example.chorushop.domain.company.dto.CompanyRes;
import com.example.chorushop.domain.company.entity.Company;
import com.example.chorushop.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository repository;
    @Override
    public Long create(CompanyReq req) {
        Company company = repository.save(
                Company.builder()
                        .companyName(req.companyName())
                        .companyNum(req.companyNum())
                        .representative(req.representative())
                        .address(req.address())
                        .bizType(req.bizType()).build()
        );
        return company.getId();
    }

    @Override
    @Transactional
    public CompanyRes update(Long id, CompanyReq req) {
        Company company = getCompanyById(id);
        company.update(req.companyName(), req.companyNum(), req.representative(), req.bizType(), req.address());
        return new CompanyRes(company.getId(),
                company.getCompanyName(),
                company.getCompanyNum(),
                company.getRepresentative(),
                company.getBizType(),
                company.getAddress());
    }

    @Override
    public void delete(Long id) {
        Company company = getCompanyById(id);
        repository.delete(company);
    }

    @Override
    public CompanyRes get(Long id) {
        Company company = getCompanyById(id);
        return new CompanyRes(company.getId(),
                company.getCompanyName(),
                company.getCompanyNum(),
                company.getRepresentative(),
                company.getBizType(),
                company.getAddress());
    }

    @Override
    public List<CompanyRes> getList() {
        List<Company> companies = getCompanies();
        return companies
                .stream()
                .map(company -> new CompanyRes(company.getId(),
                                               company.getCompanyName(),
                                               company.getCompanyNum(),
                                               company.getRepresentative(),
                                               company.getBizType(),
                                               company.getAddress()))
                .toList();
    }

    private Company getCompanyById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RestApiException(RestApiExceptionCode.NOT_FOUND, "회사 정보가 없습니다."));
    }

    private List<Company> getCompanies(){
        List<Company> companies = repository.findAll();
        if(companies.isEmpty()){
            throw new RestApiException(RestApiExceptionCode.NOT_FOUND, "회사 목록이 없습니다.");
        }
        return companies;
    }
}
