package com.example.chorushop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column
    private String category;

    @Column
    private Long companyId;

    public Product(String name, Integer price, String category, Long companyId){
        this.name = name;
        this.price = price;
        this.category = category;
        this.companyId = companyId;
    }

    public void update(String name, Integer price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
