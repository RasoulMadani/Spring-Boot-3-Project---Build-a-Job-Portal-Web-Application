package com.app.jobportal.services;

import com.app.jobportal.entity.UsersType;
import com.app.jobportal.repository.UsersTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class UsersTypeService {
    private final UsersTypeRepository usersTypeRepository;

    public List<UsersType> getAll(){
        return usersTypeRepository.findAll();
    }
}
