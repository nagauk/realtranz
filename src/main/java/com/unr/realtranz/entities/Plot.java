package com.unr.realtranz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unr.realtranz.models.PlotStatus;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "venture_plot", joinColumns = @JoinColumn(name = "venture_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "plot_id", referencedColumnName = "id"))
    private Venture venture;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "plot", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Enquiry> enquiries;

    //this column is for to identify booked plot user
    @Column
    private String owner;

    @Column( nullable = false)
    private String plotId;
    @Column(nullable = false)
    private int plotSize;
    @Column
    private String width;
    @Column
    private String length;

    @Column(nullable = false)
    private String top;

    @Column(nullable = false)
    private String leftPos;

    @Column(nullable = false)
    private String facing;
    @Column
    private int price;
    @Column
    private boolean includeGovtCharges;
    @Column(nullable = false)
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

    public Venture getVenture() {
        return venture;
    }

    public void setVenture(Venture venture) {
        this.venture = venture;
    }

    public List<Enquiry> getEnquiries() {
        return enquiries;
    }

    public void setEnquiries(List<Enquiry> enquiries) {
        this.enquiries = enquiries;
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
