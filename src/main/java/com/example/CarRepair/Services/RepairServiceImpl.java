package com.example.CarRepair.Services;

import com.example.CarRepair.Converter.RepairToRepairForm;
import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Exceptions.RepairSearchException;
import com.example.CarRepair.Model.RepairForm;
import com.example.CarRepair.Repositories.RepairRepository;
import com.example.CarRepair.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void CreateRepair(Repair repair){
        Repair retrievedRepair;
        retrievedRepair = repairRepository.save(repair);
    }

    @Override
    public List<RepairForm> SearchRepair(String taxnumber, String plateNumber, LocalDateTime startDate, LocalDateTime endDate)throws Exception{
        List<Repair> repairsFound = new ArrayList<Repair>();
        repairsFound=repairRepository.findAll();
        User userByTax;
//        if(taxnumber.isEmpty()){
//            try
//            {
//                Integer tax = Integer.parseInt(taxnumber);
//                userByTax =userRepository.findByTaxNumber(tax);
//                repairsFound=repairRepository.findByUserOrPlateNumberOrDayOfRepairBetween(userByTax,plateNumber,startDate,endDate);
//
//            }
//            catch(NumberFormatException FormatEx) {
//                System.out.println("Tax number must be a an integer");
//            }
//        }
        if(!taxnumber.isEmpty()){
            try {
                Integer tax = Integer.parseInt(taxnumber);
                userByTax =userRepository.findByTaxNumber(tax);
                //repairsFound.addAll(repairRepository.findByUser(userByTax));
                addAllIfNotNull(repairsFound, repairRepository.findByUser(userByTax));
            }catch(NumberFormatException FormatEx) {
                System.out.println("Tax number must be a an integer");
            }
        }
        if (!plateNumber.isEmpty()){
            //repairsFound.addAll(repairRepository.findByPlateNumber(plateNumber));
            addAllIfNotNull(repairsFound,repairRepository.findByPlateNumber(plateNumber));
        }
        if ((startDate!=null) && (endDate!=null)) {
            //List<Repair> repairByDates=repairRepository.findBydayOfRepairBetween(inputData.getStartDate(),inputData.getEndDate());
            //repairsFound.addAll(repairRepository.findBydayOfRepairBetween(startDate,endDate));
            addAllIfNotNull(repairsFound,repairRepository.findBydayOfRepairBetween(startDate,endDate));
        }
        else if  (startDate!=null){
            //repairsFound.addAll(repairRepository.findByDayOfRepair(startDate));
            addAllIfNotNull(repairsFound,repairRepository.findByDayOfRepair(startDate));
        }
        else if (endDate!=null){
            //repairsFound.addAll(repairRepository.findByDayOfRepair(endDate));
            addAllIfNotNull(repairsFound,repairRepository.findByDayOfRepair(endDate));

        }
        if(repairsFound.isEmpty()){
            System.out.println("You can search a repair by tax number, plate number, or a set of dates");
            throw new RepairSearchException("Repair can not found");
        }
        //return repairsFound;

        return repairsFound
                .stream()
                .map(RepairToRepairForm::TypeCastRepair)
                .collect(Collectors.toList());
    }

    public static <E> void addAllIfNotNull(List<E> list, Collection<? extends E> c) {
        if (c != null) {
            list.addAll(c);
        }
    }
    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}

