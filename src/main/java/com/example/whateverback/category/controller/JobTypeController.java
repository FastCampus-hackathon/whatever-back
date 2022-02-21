package com.example.whateverback.category.controller;

import com.example.whateverback.category.service.JobTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class JobTypeController {

    private final JobTypeService jobTypeService;

    @GetMapping("/jobType")
    public ResponseEntity<List<String>> getWorkTypeList() {
        return new ResponseEntity(jobTypeService.getWorkTypeList(), HttpStatus.OK);
    }
}
