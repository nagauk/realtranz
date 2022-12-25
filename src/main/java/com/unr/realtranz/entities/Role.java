package com.unr.realtranz.entities;

import javax.persistence.*;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:24-12-2022 23:52
 **/
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role() {

    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
