package com.example.chorushop.domain.company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column
    private String companyName;

    @Column
    private String companyNum;

    @Column
    private String representative;

    @Column
    private String bizType;

    @Column
    private String address;

    public void update(String companyName, String companyNum, String representative, String bizType, String address){
        this.companyName =  companyName;
        this.companyNum = companyNum;
        this.representative = representative;
        this.bizType = bizType;
        this.address = address;
    }
}
