package com.example.whateverback.category.controller;

import com.example.whateverback.category.service.IndustryService;
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
public class IndustryController {

    private final IndustryService industryService;

    @GetMapping("/industry")
    public ResponseEntity getIndustry() {
        return new ResponseEntity(industryService.getIndustryList(), HttpStatus.OK);
    }

    @GetMapping("/industry/{mid_name}")
    public ResponseEntity getIndustryByMName(@PathVariable("mid_name") String midName) {
        return new ResponseEntity(industryService.getIndustryListByMidName(midName), HttpStatus.OK);
    }

}
