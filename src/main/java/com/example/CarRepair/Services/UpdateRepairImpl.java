package com.example.CarRepair.Services;

import com.example.CarRepair.Converter.RepairToRepairFormConverter;
import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairUpdateForm;
import com.example.CarRepair.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateRepairImpl implements UpdateRepair
{


    @Autowired
    RepairRepository repairRepository;


//vriskei to sygekrimeno repair apo to id tou kai to epistrefei
    @Override
    public Repair findOneRepair(Long repairID)
    {
        Repair repair=repairRepository.findByRepairID(repairID);
        return repair;
    }



 //pairnei ena repair kai to apothikeuei
    @Override
    public void UpdateRepair(Repair repair) throws Exception
    {
    repair=repairRepository.save(repair);
    }



//vriskei ena repair mesw toy id toy kai epistrefei
    //mia forma me ta stoixeia toy.Vevaia ayto den ginetai kateutheian
    //giati to return edw kalei auth th synarthsh p tha parei ta
    //dedomena t repair kai tha ta valei se forma kai apo ekei tha epistrafei forma
    public RepairUpdateForm findRepair(Long repairID)
    {

        Repair repair = repairRepository.findByRepairID(repairID);
        return RepairToRepairFormConverter.convert(repair);
    }



}
