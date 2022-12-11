package com.unr.realtranz.entities;

import com.unr.realtranz.models.PlotStatus;

import javax.persistence.*;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:16-06-2022 23:29
 **/
@Entity
@Table
public class Plot extends Audiatable{
    @Id
    @SequenceGenerator(name = "plotSeqGen", sequenceName = "plotSeq", initialValue = 1, allocationSize = 10000000)
    @GeneratedValue(generator = "plotSeqGen")
    private Long id;

   @Column
    private String venture;

    @Column
    private String owner;

    @Column
    private String plotId;
    @Column
    private int plotSize;
    @Column
    private String width;
    @Column
    private String length;

    @Column
    private String top;

    @Column
    private String leftPos;

    @Column
    private String facing;
    @Column
    private int price;
    @Column
    private boolean includeGovtCharges;
    @Column
    private PlotStatus pltStatus;

    @Column
    private String plotRegisteredUser;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPlotRegisteredUser() {
        return plotRegisteredUser;
    }

    public void setPlotRegisteredUser(String plotRegisteredUser) {
        this.plotRegisteredUser = plotRegisteredUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getPlotId() {
        return plotId;
    }

    public void setPlotId(String plotId) {
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

    public PlotStatus getPltStatus() {
        return pltStatus;
    }

    public void setPltStatus(PlotStatus pltStatus) {
        this.pltStatus = pltStatus;
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

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getLeftPos() {
        return leftPos;
    }

    public void setLeftPos(String leftPos) {
        this.leftPos = leftPos;
    }
}
