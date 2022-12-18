package com.unr.realtranz.controller;

import com.unr.realtranz.entities.Organization;
import com.unr.realtranz.service.OrganizationService;
import com.unr.realtranz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:15-12-2022 00:20
 **/
@RestController
public class OrganizationController {

    @Autowired
    OrganizationService orgService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/org",method = RequestMethod.POST)
    public ResponseEntity saveOrganization(@RequestBody Organization org){
        orgService.saveOrg(org);
        return new ResponseEntity<>("Created Organization", HttpStatus.CREATED);
    }

    @RequestMapping(value="/org/{org}",method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable("org") String orgName){
        return orgService.getOrg(orgName);
    }
}
