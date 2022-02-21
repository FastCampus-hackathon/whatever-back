package com.example.whateverback;

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
    @Column(nullable = false)
    private Long ind_mcd;  //상위코드
    @Column(nullable = false)
    private Long ind_bcd; //업종코드
    @Column(nullable = false)
    private Long ind_cd; //코드
    @Column(nullable = false)
    private String name; //업종 키워드명

}
