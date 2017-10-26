package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairRow;

public class RepairListToRepairListConverter
{

    //ta stoixeia tou kathe Repair object ths listas ta
    //topothetoume se antikeimeno formas repairRow

    public static RepairRow convert(Repair repair)
    {
        RepairRow repairRow = new RepairRow();
        repairRow.setDayOfRepair(repair.getDayOfRepair());
        repairRow.setDescription(repair.getDescription());
        repairRow.setPlateNumber(repair.getPlateNumber());
        repairRow.setRepairStatus(repair.getRepairStatus());
        repairRow.setServiceCost(repair.getServiceCost());
        repairRow.setRepairType(repair.getRepairType());
        repairRow.setTaxNumber(repair.getUser().getTaxNumber());
        return repairRow;

    }



}
