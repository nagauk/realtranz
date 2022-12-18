package com.unr.realtranz.service;

import com.unr.realtranz.entities.Organization;
import com.unr.realtranz.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:15-12-2022 00:21
 **/
@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    public void saveOrg(Organization org){
        organizationRepository.save(org);
    }

    public Organization getOrg(String name){
        return organizationRepository.findByName(name);
    }
}
