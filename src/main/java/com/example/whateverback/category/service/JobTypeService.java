package com.example.whateverback.category.service;

import com.example.whateverback.category.model.entity.JobType;
import com.example.whateverback.category.repository.JobTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobTypeService {

    private final JobTypeRepository jobTypeRepository;

    public List<String> getWorkTypeList() {
        return jobTypeRepository.findAll().stream().map(JobType::getJobTypeName).collect(Collectors.toList());
    }
}
