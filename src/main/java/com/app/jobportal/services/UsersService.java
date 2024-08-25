package com.app.jobportal.services;

import com.app.jobportal.entity.Users;
import com.app.jobportal.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    public Users addNew(Users users){
        users.setIsActive(Boolean.TRUE);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        return usersRepository.save(users);
    }
}
