package com.example.CarRepair.Model;

import java.time.LocalDateTime;

public class RepairUpdateForm
{



    private String description;
    private LocalDateTime dayOfRepair;
    private String repairStatus;
    private String repairType;
    private Double serviceCost;
    private String plateNumber;
    private Integer taxNumber;
    private Long userID;
    private Long repairID;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getRepairID() {
        return repairID;
    }

    public void setRepairID(Long repairID) {
        this.repairID = repairID;
    }

    public Integer getTaxNumber()
    {
        return taxNumber;
    }

    public void setTaxNumber(Integer taxNumber)
    {
        this.taxNumber = taxNumber;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDayOfRepair() {
        return dayOfRepair;
    }

    public void setDayOfRepair(LocalDateTime dayOfRepair) {
        this.dayOfRepair = dayOfRepair;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
