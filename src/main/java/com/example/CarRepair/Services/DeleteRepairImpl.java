package com.example.CarRepair.Services;

import com.example.CarRepair.Repositories.RepairRepository;
import com.example.CarRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteRepairImpl implements DeleteRepair {

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public void delete(Long repairID) {
        repairRepository.delete(repairID);
    }
}