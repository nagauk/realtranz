package com.unr.realtranz.controller;

import com.unr.realtranz.entities.Users;
import com.unr.realtranz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:25-12-2022 00:40
 **/
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public Users userRegistrationDto() {
        return new Users();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") Users users) {
        userService.save(users);
        return "redirect:/registration?success";
    }
}