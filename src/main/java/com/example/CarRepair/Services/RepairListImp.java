package com.example.CarRepair.Services;


import com.example.CarRepair.Converter.RepairListToRepairListConverter;
import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairRow;
import com.example.CarRepair.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RepairListImp implements RepairList
{

 @Autowired
    RepairRepository repairRepository;



 //ekteloume to query na mas ferei ta top10 servises mesw bean toy repository
 // ta vazoyme se mia lista poy exei repairs
 //epistrefoume mia lista p exei repairRow mesa(dld lista se forma)
 //to opoio exei ginei mesw mapping


 @Override
 public List<RepairRow> findTop10ByOrderByDayOfRepair()
 {

     List<Repair> serviceList=repairRepository.findTop10ByOrderByDayOfRepair();


     return serviceList

             .stream()
             .map(RepairListToRepairListConverter::convert)
             .collect(Collectors.toList());
 }










}
