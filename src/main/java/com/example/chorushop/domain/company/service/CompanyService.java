package com.example.chorushop.domain.company.service;

import com.example.chorushop.domain.company.dto.CompanyReq;
import com.example.chorushop.domain.company.dto.CompanyRes;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CompanyService {

     Long create(CompanyReq req);

     CompanyRes update(Long id, CompanyReq req);

     void delete(Long id);

     CompanyRes get(Long id);

     List<CompanyRes> getList();
}
