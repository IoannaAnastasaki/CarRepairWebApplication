package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Repositories.RepairRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairRepository repairRepository;


    @Override
    public void CreateRepair(Repair repair){
        Repair retrievedRepair;
        retrievedRepair = repairRepository.save(repair);
    }
}

