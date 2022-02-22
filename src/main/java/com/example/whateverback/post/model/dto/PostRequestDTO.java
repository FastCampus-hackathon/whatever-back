package com.example.whateverback.post.model.dto;

import com.example.whateverback.category.service.IndustryService;
import com.example.whateverback.category.service.JobService;
import com.example.whateverback.category.service.JobTypeService;
import com.example.whateverback.category.service.LocationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostRequestDTO {

    private String jobMidCd;
    private String jobTypeCd ;
    private String locBcd;
    private String locMcd;
    private Long start = 0L;
    private Long count = 10L;
    private String keywords = "";
    private String sort = "";

    public String getUrl(String url, IndustryService industryService, JobService jobService, JobTypeService jobTypeService, LocationService locationService) {
        return url
                + "&job_mid_cd=" + jobService.getJobMidCd(jobMidCd)
                + "&job_type_cd=" + jobTypeService.getJobTypeByName(jobTypeCd)
                + "&loc_bcd=" + locationService.getLocationBcdByName(locBcd)
                + "&loc_mcd=" + locationService.getLocationMcdByName(locMcd)
                + "&start=" + start
                + "&count=" + count
                + "&keywords=" + keywords
                + "&sort=" + sort;
    }
}
