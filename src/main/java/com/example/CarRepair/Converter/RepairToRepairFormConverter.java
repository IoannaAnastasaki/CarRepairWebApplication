package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairUpdateForm;

import java.time.LocalDateTime;

public class RepairToRepairFormConverter
{


    public static RepairUpdateForm convert(Repair repair) {

        RepairUpdateForm repairForm = new RepairUpdateForm();

        repairForm.setDescription(repair.getDescription());
        repairForm.setDayOfRepair(repair.getDayOfRepair());
        repairForm.setPlateNumber(repair.getPlateNumber());
        repairForm.setRepairStatus(repair.getRepairStatus());
        repairForm.setRepairType(repair.getRepairType());
        repairForm.setServiceCost(repair.getServiceCost());
        repairForm.setRepairID(repair.getRepairID());
        repairForm.setUserID(repair.getUser().getUserID());
        return repairForm;
    }



}
