package com.example.chorushop.domain.consumer.entity;

import com.example.chorushop.domain.consumer.dto.ConsumerCreateReq;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String loginId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Integer age;

    @Column
    private Integer phoneNum;

    @Column
    private String address;

    @Column
    private String addressDetail;

    @Column
    private Integer addressNum;

    public static Consumer from(ConsumerCreateReq req){
        return Consumer.builder()
                .loginId(req.getLoginId())
                .name(req.getName())
                .email(req.getEmail())
                .age(req.getAge())
                .phoneNum(req.getPhoneNum())
                .address(req.getAddress())
                .addressDetail(req.getAddressDetail())
                .addressNum(req.getAddressNum())
                .build();
    }

}
