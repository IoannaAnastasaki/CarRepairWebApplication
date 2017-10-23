package com.example.CarRepair.Model;

import com.example.CarRepair.Domain.User;

import java.time.LocalDateTime;
import java.util.Date;

public class RepairRow
{
    // private Long userID;
    //prepei na mpei?den uparxei to domain toy Repair


    private String description;
    private LocalDateTime dayOfRepair;
    private String repairStatus;
    private String repairType;
    private Double serviceCost;
    private String plateNumber;
    private Integer taxNumber;

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
