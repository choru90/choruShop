package com.example.chorushop.domain.company.web.data;

import com.example.chorushop.domain.company.entity.Company;
import com.example.chorushop.domain.company.web.repository.TestCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.transaction.TestTransaction;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyDataSetUp {

    @Autowired
    private TestCompanyRepository repository;

    protected void transactionCommit() {
        TestTransaction.flagForCommit();
        TestTransaction.end();
    }

    public Company createCompany(){
        Company company = repository.saveAndFlush(new Company(null,
                "무한상사",
                "127-08-12345",
                "김대표",
                "유통",
                "서울시 강남구"));

        transactionCommit();
        return company;
    }

    public List<Company> creatCompanies(){
        Company company1 = new Company(null,
                "무한상사",
                "127-08-12345",
                "김대표",
                "유통",
                "서울시 강남구");


        Company company2 = new Company(null,
                "무한상사",
                "127-08-12345",
                "김대표",
                "유통",
                "서울시 강남구");

        Company company3 = new Company(null,
                "무한상사",
                "127-08-12345",
                "김대표",
                "유통",
                "서울시 강남구");

        List<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);
        companies.add(company3);
        repository.saveAll(companies);
        transactionCommit();

        return companies;
    }

    public Company createCompanyById(Long id){
        Company company = repository.save(new Company(id,
                "무한상사",
                "127-08-12345",
                "김대표",
                "유통",
                "서울시 강남구"));
        transactionCommit();
        return company;
    }


}
