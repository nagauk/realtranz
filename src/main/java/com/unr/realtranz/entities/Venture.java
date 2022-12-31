package com.unr.realtranz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unr.realtranz.model.VentureType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.sql.Clob;
import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 {@code @Date:16-06-2022} 22:10
 **/
@Entity
@Table
public class Venture {
    @Id
    @SequenceGenerator(name = "ventureSeqGen", sequenceName = "ventureSeq", initialValue = 1, allocationSize = 10000000)
    @GeneratedValue(generator = "ventureSeqGen")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_venture", joinColumns = @JoinColumn(name = "venture_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Users owner;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "venture", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Plot> plotList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "org_venture", joinColumns = @JoinColumn(name = "org_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "venture_id", referencedColumnName = "id"))
    private Organization organization;

    @Column(unique = true, nullable = false)
    private String ventureName;
    @Column
    private String ventureAddress;

    @Lob
    @Column
    private String mapLocation;
    @Column(nullable = false)
    private String VentureStatus;
    @Column(nullable = false)
    private int actualPrice;
    @Column(nullable = false)
    private int offerPrice;

    @Column
    private String message;

    @Column(nullable = false)
    private String locality;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column
    private String description;

    @Lob
    @Column
    private String ventureFeatures;
    @Lob
    @Column
    private String ventureHighlights;

    @Column
    private VentureType ventureType;

    @Column
    private boolean reraApproved;

    @Column
    private String approvedAuthority;

    public VentureType getVentureType() {
        return ventureType;
    }

    public void setVentureType(VentureType ventureType) {
        this.ventureType = ventureType;
    }

    public boolean isReraApproved() {
        return reraApproved;
    }

    public void setReraApproved(boolean reraApproved) {
        this.reraApproved = reraApproved;
    }

    public String getApprovedAuthority() {
        return approvedAuthority;
    }

    public void setApprovedAuthority(String approvedAuthority) {
        this.approvedAuthority = approvedAuthority;
    }

    public List<Plot> getPlotList() {
        return plotList;
    }

    public void setPlotList(List<Plot> plotList) {
        this.plotList = plotList;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public String getVentureName() {
        return ventureName;
    }

    public void setVentureName(String ventureName) {
        this.ventureName = ventureName;
    }

    public String getVentureAddress() {
        return ventureAddress;
    }

    public void setVentureAddress(String ventureAddress) {
        this.ventureAddress = ventureAddress;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    public String getVentureStatus() {
        return VentureStatus;
    }

    public void setVentureStatus(String ventureStatus) {
        VentureStatus = ventureStatus;
    }

    public int getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(int offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVentureFeatures() {
        return ventureFeatures;
    }

    public void setVentureFeatures(String ventureFeatures) {
        this.ventureFeatures = ventureFeatures;
    }

    public String getVentureHighlights() {
        return ventureHighlights;
    }

    public void setVentureHighlights(String ventureHighlights) {
        this.ventureHighlights = ventureHighlights;
    }
}
