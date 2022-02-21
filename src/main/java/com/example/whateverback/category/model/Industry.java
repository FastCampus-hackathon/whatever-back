package com.example.whateverback.category.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Industry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //업종번호

    @Column(nullable = false, name = "ind_mcd")
    private Long indMcd;  //상위코드

    @Column(nullable = false, name = "ind_bcd")
    private Long indBcd; //업종코드

    @Column(nullable = false, name = "ind_cd")
    private Long indCd; //코드

    @Column(nullable = false)
    private String name; //업종 키워드명

}
