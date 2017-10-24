package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairForm;
import com.example.CarRepair.Model.SearchRepairForm;

import java.time.LocalDateTime;
import java.util.List;

public interface RepairService {
    void CreateRepair(Repair repair);

    public List<RepairForm> SearchRepair(String taxnumber, String plateNumber, LocalDateTime startDate, LocalDateTime endDate)throws Exception;
}
