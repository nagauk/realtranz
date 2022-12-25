package com.unr.realtranz.controller;

import com.unr.realtranz.config.SimpleLogoutHandler;
import com.unr.realtranz.entities.Users;
import com.unr.realtranz.model.UserModel;
import com.unr.realtranz.service.PlotService;
import com.unr.realtranz.service.UserService;
import com.unr.realtranz.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:07-06-2022 01:34
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(){
        ModelAndView modelAndView = new ModelAndView("dashboard");
        return modelAndView;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

}
