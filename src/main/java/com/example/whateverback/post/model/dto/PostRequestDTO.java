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

    private String job;
    private String job_type ;
    private String loc_bcd;
    private String loc_mcd;
    private Long start = 0L;
    private Long count = 10L;
    private String keywords = "";
    private String sort = "";

    public String getUrl(String url, JobService jobService, JobTypeService jobTypeService, LocationService locationService) {
        return url
                + "&job_mid_cd=" + jobService.getJobMidCd(job)
                + "&job_type_cd=" + jobTypeService.getJobTypeByName(job_type)
                + "&loc_bcd=" + locationService.getLocationBcdByName(loc_bcd)
                + "&loc_mcd=" + locationService.getLocationMcdByName(loc_mcd)
                + "&start=" + start
                + "&count=" + count
                + "&keywords=" + keywords
                + "&sort=" + sort;
    }
}
