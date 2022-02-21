package com.example.whateverback.category.controller;

import com.example.whateverback.category.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class JobController {

    private final JobService jobService;

    @GetMapping("/job")
    public ResponseEntity getJobList() {
        return new ResponseEntity(jobService.getJobList(), HttpStatus.OK);
    }

}
