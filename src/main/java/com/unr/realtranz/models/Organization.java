package com.unr.realtranz.models;

import com.unr.realtranz.entities.Users;
import com.unr.realtranz.entities.Venture;

import javax.persistence.*;
import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:17-06-2022 22:58
 **/
public class Organization {
    private String name;
    private String description;
    private List<Venture> ventureList;
    private Users owner;
    private String orgStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Venture> getVentureList() {
        return ventureList;
    }

    public void setVentureList(List<Venture> ventureList) {
        this.ventureList = ventureList;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ventureList=" + ventureList +
                ", owner=" + owner +
                ", orgStatus='" + orgStatus + '\'' +
                '}';
    }
}
