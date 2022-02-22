package com.example.whateverback.like.controller;

import com.example.whateverback.like.model.dto.TaggingRequestDTO;
import com.example.whateverback.like.service.TaggingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaggingController {

    private final TaggingService taggingService;

    @PutMapping("/tagging")
    public ResponseEntity addTagging(@RequestBody TaggingRequestDTO taggingRequestDTO) {
        taggingService.addTagging(taggingRequestDTO);
        return new ResponseEntity("Tagging success", HttpStatus.OK);
    }
}
