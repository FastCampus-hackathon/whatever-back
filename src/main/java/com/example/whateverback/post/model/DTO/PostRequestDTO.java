package com.example.whateverback.post.model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostRequestDTO {
    private String jobMidCd = "";
    private String jobTypeCd = "";
    private String locBcd = "";
    private String locMcd = "";
    private String indMcd = "";
    private String indCd = "";
    private Long start = 0L;
    private Long count = 10L;
    private String keyword = "";
    private String sort = "";

    public String getUrl(String url) {
        return url
                + "&job_mid_cd=" + jobMidCd
                + "&job_type_cd=" + jobTypeCd
                + "&loc_bcd=" + locBcd
                + "&loc_mcd=" + locMcd
                + "&ind_mcd=" + indMcd
                + "&ind_cd=" + indCd
                + "&start=" + start
                + "&count=" + count
                + "&keyword=" + keyword
                + "&sort=" + sort;
    }
}
