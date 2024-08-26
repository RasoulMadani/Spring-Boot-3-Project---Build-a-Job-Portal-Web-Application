package com.app.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_profile")
@ToString
public class JobSeekerProfile {
    @Id
    private int userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String workAuthorization;
    private String employmentType;
    private String resume;
    @Column(nullable = true,length = 64)
    private String profilePhoto;
    @OneToMany(targetEntity = Skills.class,cascade = CascadeType.ALL,mappedBy = "jobSeekerProfile")
    private List<Skills> skills;
    public JobSeekerProfile(Users userId){
        this.userId = userId;
    }

}
