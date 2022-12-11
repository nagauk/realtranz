package com.unr.realtranz.repository;

import com.unr.realtranz.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:07-06-2022 01:28
 **/
@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String userName);
}
