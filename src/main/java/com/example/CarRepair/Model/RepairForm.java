package com.example.CarRepair.Model;

import java.time.LocalDateTime;

public class RepairForm {

    private String taxNumber;
    private Long repairID;
    private String description;
    private LocalDateTime dayOfRepair;
    private String repairStatus;
    private String repairType;
    private String repaierCost;
    private String plateNumber;

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Long getRepairID() {
        return repairID;
    }

    public void setRepairID(Long repairID) {
        this.repairID = repairID;
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

    public String getRepaierCost() {
        return repaierCost;
    }

    public void setRepaierCost(String repaierCost) {
        this.repaierCost = repaierCost;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
