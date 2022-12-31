package com.unr.realtranz.controller;

import com.unr.realtranz.config.SimpleLogoutHandler;
import com.unr.realtranz.entities.Users;
import com.unr.realtranz.entities.Venture;
import com.unr.realtranz.model.UserModel;
import com.unr.realtranz.service.PlotService;
import com.unr.realtranz.service.UserService;
import com.unr.realtranz.service.UserServiceImpl;
import com.unr.realtranz.service.VentureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    VentureService ventureService;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(){
        String userName  = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userService.getUsersByUserName(userName);
        List<Venture> ventures = ventureService.getAllVenturesByUser(user);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("userVentures",ventures);
        ModelAndView modelAndView = new ModelAndView("dashboard",modelMap);
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
