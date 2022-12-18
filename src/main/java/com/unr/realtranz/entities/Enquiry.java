package com.unr.realtranz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:08-12-2022 01:42
 **/
@Entity
@Table
public class Enquiry extends Audiatable{
    @Id
    @SequenceGenerator(name = "enquirySeqGen", sequenceName = "enquirySeq", initialValue = 1, allocationSize = 10000000)
    @GeneratedValue(generator = "enquirySeqGen")
    private Long id;

    @Column(nullable = false)
    private String userName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "plot_enquiry", joinColumns = @JoinColumn(name = "plot_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "enquiry_id", referencedColumnName = "id"))
    private Plot plot;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column
    private String details;

    @Column(nullable = false)
    private String venture;

    @Column(nullable = false)
    private String description;

    @Column
    private Integer expectedPrice;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(Integer expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getVenture() {
        return venture;
    }

    public void setVenture(String venture) {
        this.venture = venture;
    }
}
