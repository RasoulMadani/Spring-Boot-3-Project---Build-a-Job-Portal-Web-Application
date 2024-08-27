package com.app.jobportal.services;

import com.app.jobportal.entity.JobSeekerProfile;
import com.app.jobportal.entity.RecruiterProfile;
import com.app.jobportal.entity.Users;
import com.app.jobportal.repository.JobSeekerProfileRepository;
import com.app.jobportal.repository.RecruiterProfileRepository;
import com.app.jobportal.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final PasswordEncoder passwordEncoder;

    public Users addNew(Users users){
        users.setIsActive(Boolean.TRUE);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users saveUser = usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();

        if(userTypeId == 1){
            recruiterProfileRepository.save(new RecruiterProfile(saveUser));
        }else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(saveUser));
        }
        return saveUser;
    }
    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }
}
