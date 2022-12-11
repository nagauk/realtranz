package com.unr.realtranz.model;

import javax.persistence.Column;
import javax.persistence.Id;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:07-06-2022 01:29
 **/
public class UserModel {

    private int num;

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
