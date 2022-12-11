package com.unr.realtranz.models;import com.unr.realtranz.entities.Venture;import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:17-06-2022 22:58
 **/
public class Plot {
    private String venture;
    private int plotId;
    private int plotSize;
    private String width;
    private String length;
    private String facing;
    private int price;
    private boolean includeGovtCharges;
    private String pltStatus;
    private String plotRegisteredUser;


    public int getPlotId() {
        return plotId;
    }

    public void setPlotId(int plotId) {
        this.plotId = plotId;
    }

    public int getPlotSize() {
        return plotSize;
    }

    public void setPlotSize(int plotSize) {
        this.plotSize = plotSize;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getVenture() {
        return venture;
    }

    public void setVenture(String venture) {
        this.venture = venture;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isIncludeGovtCharges() {
        return includeGovtCharges;
    }

    public void setIncludeGovtCharges(boolean includeGovtCharges) {
        this.includeGovtCharges = includeGovtCharges;
    }

    public String getPltStatus() {
        return pltStatus;
    }

    public void setPltStatus(String pltStatus) {
        this.pltStatus = pltStatus;
    }

    public String getPlotRegisteredUser() {
        return plotRegisteredUser;
    }

    public void setPlotRegisteredUser(String plotRegisteredUser) {
        this.plotRegisteredUser = plotRegisteredUser;
    }
}
