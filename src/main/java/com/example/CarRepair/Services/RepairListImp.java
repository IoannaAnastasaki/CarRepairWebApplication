package com.example.CarRepair.Services;


import com.example.CarRepair.Converter.RepairListToRepairListConverter;
import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairRow;
import com.example.CarRepair.Repositories.RepairRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RepairListImp implements RepairList
{

 @Autowired
    RepairRepository repairRepository;

 @Override
 public List<RepairRow> findTop10ByOrderByDayOfRepair()
 {

     List <Repair> serviceList=repairRepository.findTop10ByOrderByDayOfRepair();


     return serviceList

             .stream()
             .map(RepairListToRepairListConverter::convert)
             .collect(Collectors.toList());
 }










}
