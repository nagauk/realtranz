package com.unr.realtranz.service;

import com.unr.realtranz.entities.Role;
import com.unr.realtranz.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:30-12-2022 00:50
 **/

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role getRole(Long id){
        return roleRepository.findById(id).get();
    }
}
