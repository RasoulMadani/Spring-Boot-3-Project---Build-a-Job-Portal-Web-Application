package com.app.jobportal.services;

import com.app.jobportal.entity.RecruiterProfile;
import com.app.jobportal.repository.RecruiterProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecruiterProfileService {
    private final RecruiterProfileRepository recruiterProfileRepository;
    public Optional<RecruiterProfile> getOne(Integer id){
        return recruiterProfileRepository.findById(id);
    }
}
