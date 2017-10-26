package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairUpdateForm;

public interface UpdateRepair
{


    void UpdateRepair(Repair repair) throws Exception;
    public RepairUpdateForm findRepair(Long repairID);
    public Repair findOneRepair(Long repairID);

}
