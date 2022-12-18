package com.unr.realtranz.repository;

import com.unr.realtranz.entities.Organization;
import com.unr.realtranz.entities.Venture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:15-12-2022 00:21
 **/
@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long>  {
        Organization findByName(String name);

}
