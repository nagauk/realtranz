package com.unr.realtranz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:16-06-2022 23:37
 **/
@Entity
@Table
public class Organization  extends Audiatable{
    @Id
    @SequenceGenerator(name = "orgSeqGen", sequenceName = "orgSeq", initialValue = 1, allocationSize = 10000000)
    @GeneratedValue(generator = "orgSeqGen")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String orgStatus;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "organization", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Venture> ventureList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_org", joinColumns = @JoinColumn(name = "org_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @JsonIgnore
    private Users user;
    public List<Venture> getVentureList() {
        return ventureList;
    }

    public void setVentureList(List<Venture> ventureList) {
        this.ventureList = ventureList;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

      public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }
}
