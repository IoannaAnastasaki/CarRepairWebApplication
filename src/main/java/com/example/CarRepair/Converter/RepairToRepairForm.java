package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairForm;

public class RepairToRepairForm {

    public static RepairForm TypeCastRepair (Repair repair) {
        RepairForm repairDetails = new RepairForm();

        //get it field one by one, use try cause tax number is a number only
        repairDetails.setTaxNumber(String.valueOf(repair.getUser().getTaxNumber()));
        repairDetails.setRepairID(repair.getRepairID());
        repairDetails.setDescription(repair.getDescription());
        repairDetails.setDayOfRepair(repair.getDayOfRepair());

        if (repair.getRepairStatus().equals("ToDo")){
            repairDetails.setRepairStatus("Pending");
        }else{
            repairDetails.setRepairStatus(repair.getRepairStatus());
        }
        repairDetails.setRepairType(repair.getRepairType());
        repairDetails.setPlateNumber(repair.getPlateNumber());
        repairDetails.setRepaierCost(String.valueOf(repair.getServiceCost()));

        return repairDetails;
    }
}
