package com.unr.realtranz.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venture_owner_id")
    private Users owner;

    @Column
    private String organization;
    @Column
    private String ventureName;
    @Column
    private String ventureAddress;
    @Column
    private String mapLocation;
    @Column
    private String VentureStatus;
    @Column
    private int minPrice;
    @Column
    private int maxPrice;
    @Column
    private int minSqyds;
    @Column
    private int maxSqyds;
    @Column
    private String locality;
    @Lob
    @Column
    @Type(type = "org.hibernate.type.BinaryType")
    private List<Blob> devlopementPhotos;
    @Lob
    @Column
    @Type(type = "org.hibernate.type.BinaryType")
    private List<Blob> permissionDocs;
    @Lob
    @Column
    @Type(type = "org.hibernate.type.BinaryType")
    private Blob plotLayoutImage;
    @Column
    private Clob description;
    @Column
    private String ventureFeatures;
    @Column
    private String ventureHighlights;




    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
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

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinSqyds() {
        return minSqyds;
    }

    public void setMinSqyds(int minSqyds) {
        this.minSqyds = minSqyds;
    }

    public int getMaxSqyds() {
        return maxSqyds;
    }

    public void setMaxSqyds(int maxSqyds) {
        this.maxSqyds = maxSqyds;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public List<Blob> getDevlopementPhotos() {
        return devlopementPhotos;
    }

    public void setDevlopementPhotos(List<Blob> devlopementPhotos) {
        this.devlopementPhotos = devlopementPhotos;
    }

    public List<Blob> getPermissionDocs() {
        return permissionDocs;
    }

    public void setPermissionDocs(List<Blob> permissionDocs) {
        this.permissionDocs = permissionDocs;
    }

    public Blob getPlotLayoutImage() {
        return plotLayoutImage;
    }

    public void setPlotLayoutImage(Blob plotLayoutImage) {
        this.plotLayoutImage = plotLayoutImage;
    }

    public Clob getDescription() {
        return description;
    }

    public void setDescription(Clob description) {
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
