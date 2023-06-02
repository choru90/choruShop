package com.example.chorushop.company.service;

import com.example.chorushop.company.dto.CompanyReq;
import com.example.chorushop.company.dto.CompanyRes;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {

     Long create(CompanyReq req);

     CompanyRes update(CompanyReq req);

     void delete(Long id);

     CompanyRes get(Long id);

     List<CompanyRes> getList();
}
