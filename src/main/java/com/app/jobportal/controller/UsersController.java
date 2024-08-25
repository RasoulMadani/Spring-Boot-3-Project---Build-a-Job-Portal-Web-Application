package com.app.jobportal.controller;

import com.app.jobportal.entity.Users;
import com.app.jobportal.entity.UsersType;
import com.app.jobportal.services.UsersService;
import com.app.jobportal.services.UsersTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsersController {
    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> all = usersTypeService.getAll();
        model.addAttribute("getAllTypes", all);
        model.addAttribute("user", new Users());
        return "register";
    }
    @PostMapping("/register/new")
    public String usersRegistration(@Valid Users users){
        usersService.addNew(users);
        return "dashboard";
    }

}
