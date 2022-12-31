package com.unr.realtranz.service;

import com.unr.realtranz.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    Users save(Users users);

    Users getUsersByUserName(String userName);

    void saveUser(Users users);
}
