package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairUpdateForm;

public class RepairFormToRepairConverter
{

    public static Repair convert(RepairUpdateForm repairForm, Repair retrieveRepair)
    {


        retrieveRepair.setDescription(repairForm.getDescription());
        retrieveRepair.setRepairStatus(repairForm.getRepairStatus());
        retrieveRepair.setRepairType(repairForm.getRepairType());
        retrieveRepair.setDayOfRepair(repairForm.getDayOfRepair());
        retrieveRepair.setPlateNumber(repairForm.getPlateNumber());
        retrieveRepair.setServiceCost(repairForm.getServiceCost());
        retrieveRepair.setRepairID(repairForm.getRepairID());

        return retrieveRepair;

    }

}
