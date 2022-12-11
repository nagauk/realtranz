package com.unr.realtranz.models;

import com.unr.realtranz.entities.Organization;
import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.entities.Users;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Clob;
import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:17-06-2022 22:58
 **/
public class Venture {
    private Users owner;
    private Organization organization;
    private String ventureName;
    private String ventureAddress;
    private String mapLocation;
    private String VentureStatus;
    private int minPrice;
    private int maxPrice;
    private int minSqyds;
    private int maxSqyds;
    private String locality;
    private List<Blob> devlopementPhotos;
    private List<Blob> permissionDocs;
    private Blob plotLayoutImage;
    private Clob description;
    private String ventureFeatures;
    private String ventureHighlights;
    private List<Plot> plotList;

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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

    public List<Plot> getPlotList() {
        return plotList;
    }

    public void setPlotList(List<Plot> plotList) {
        this.plotList = plotList;
    }

    @Override
    public String toString() {
        return "Venture{" +
                "owner=" + owner +
                ", organization=" + organization +
                ", ventureName='" + ventureName + '\'' +
                ", ventureAddress='" + ventureAddress + '\'' +
                ", mapLocation='" + mapLocation + '\'' +
                ", VentureStatus='" + VentureStatus + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minSqyds=" + minSqyds +
                ", maxSqyds=" + maxSqyds +
                ", locality='" + locality + '\'' +
                ", devlopementPhotos=" + devlopementPhotos +
                ", permissionDocs=" + permissionDocs +
                ", plotLayoutImage=" + plotLayoutImage +
                ", description=" + description +
                ", ventureFeatures='" + ventureFeatures + '\'' +
                ", ventureHighlights='" + ventureHighlights + '\'' +
                ", plotList=" + plotList +
                '}';
    }
}
