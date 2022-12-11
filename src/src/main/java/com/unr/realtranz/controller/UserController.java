package com.unr.realtranz.controller;

import com.unr.realtranz.entities.Users;
import com.unr.realtranz.model.UserModel;
import com.unr.realtranz.service.PlotService;
import com.unr.realtranz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PlotService plotService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping( "/users")
    public ResponseEntity<List<UserModel>> getUsers(){
        List<UserModel> userModels = userService.getUsers();
        return ResponseEntity.ok(userModels);
    }

    @PostMapping( "/signup")
    public Object saveUser(@RequestBody(required = true) Users users){
        String password = users.getPassword();
        String encryptPass = bCryptPasswordEncoder.encode(password);
        users.setPassword(encryptPass);
        userService.saveUser(users);

        return "User Created";
    }

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(){
        ModelAndView modelAndView = new ModelAndView("dashboard");
        return modelAndView;
    }

    @GetMapping({"/search","/"})
    public ModelAndView getSearchResults(Model model){
        ModelMap modelMap = new ModelMap("plots",plotService.getAllPlotsByVenture("udyana"));
        ModelAndView modelAndView = new ModelAndView("searchresults",modelMap);
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLogin(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }


}
