package com.example.chorushop.domain.company.service;

import com.example.chorushop.domain.company.dto.CompanyReq;
import com.example.chorushop.domain.company.entity.Company;
import com.example.chorushop.domain.company.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    CompanyService service;

    @Mock
    CompanyRepository repository;

    @Test
    void createTest(){
        // given
        service = new CompanyServiceImpl(repository);
        String companyName = "삼선전자";
        String companyNum ="123871234";
        String representative = "김대표";
        String bizType = "제조업";
        String address = "서울시 강남구";
        Long id = 1L;
        CompanyReq req = new CompanyReq(companyName, companyNum, representative, bizType, address);
        when(repository.save(any())).thenReturn(Company.builder().id(id).build());
        // when
        Long savedId = service.create(req);
        // then
        assertNotNull(savedId);
        verify(repository).save(any());
    }
}
