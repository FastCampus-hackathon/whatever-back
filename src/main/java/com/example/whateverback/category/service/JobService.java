package com.example.whateverback.category.service;

import com.example.whateverback.category.model.entity.Job;
import com.example.whateverback.category.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public List<String> getJobList() {
        return jobRepository.findAllName();
    }

}
