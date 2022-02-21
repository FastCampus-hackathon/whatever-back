package com.example.whateverback.category.model.entity;

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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //근무지번호

    @Column(nullable = false, name = "loc_mcd")
    private Long locMcd; //1차 근무지

    @Column(nullable = false, name = "loc_bcd")
    private Long locBcd; //2차 근무지

    @Column(nullable = false, name = "loc_cd")
    private Long locCd; //3차 근무지

    @Column(nullable = false)
    private String name;

}
