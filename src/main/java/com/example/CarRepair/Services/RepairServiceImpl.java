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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public List<RepairForm> SearchRepair(String searchInput, LocalDateTime startDate, LocalDateTime endDate)throws Exception{
        List<Repair> repairsFound = new ArrayList<Repair>();

        Pattern platePattern =Pattern.compile("[A-Z][A-Z][A-Z]\\\\-[1-9][0-9][0-9][0-9]");
        Pattern taxPattern= Pattern.compile("\\d\\d\\d\\d\\d\\d\\d\\d\\d");

        Matcher plateMach=platePattern.matcher(searchInput);
        Matcher taxMach=taxPattern.matcher(searchInput);

        if(plateMach.find()){
            addAllIfNotNull(repairsFound,findRepairsWithPlate(searchInput, startDate, endDate));
        }
        else if(taxMach.find()){
            addAllIfNotNull(repairsFound,findRepairsWithTax(searchInput, startDate, endDate));

        } else if ((startDate!=null) && (endDate!=null)) {
            addAllIfNotNull(repairsFound,repairRepository.findBydayOfRepairBetween(startDate,endDate));
        }
        else if  (startDate!=null){
            addAllIfNotNull(repairsFound,repairRepository.findByDayOfRepair(startDate));
        }
        else if (endDate!=null){
            addAllIfNotNull(repairsFound,repairRepository.findByDayOfRepair(endDate));

        }
        else{
            throw new RepairSearchException("You can search a repair by tax number, plate number, or a set of dates");
        }

        if(repairsFound.isEmpty()){
            System.out.println("You can search a repair by tax number, plate number, or a set of dates");
            throw new RepairSearchException("Repair can not be found");
        }

        return repairsFound
                .stream()
                .map(RepairToRepairForm::TypeCastRepair)
                .collect(Collectors.toList());
    }

    private List<Repair> findRepairsWithPlate(String plate, LocalDateTime startDate, LocalDateTime endDate){
        if ((startDate!=null) && (endDate!=null) && (!plate.isEmpty())){
            return (repairRepository.findBydayOfRepairBetweenAndPlateNumber(startDate,endDate,plate));
        }
        else if((startDate!=null) && (endDate==null) && (!plate.isEmpty())){
            return (repairRepository.findByDayOfRepairAndPlateNumber(startDate,plate));
        }
        else if((startDate==null) && (endDate!=null) && (!plate.isEmpty())){
            return (repairRepository.findByDayOfRepairAndPlateNumber(endDate,plate));
        }
        else{
            return(repairRepository.findByPlateNumber(plate));
        }
    }

    private List<Repair> findRepairsWithTax(String taxnumber, LocalDateTime startDate, LocalDateTime endDate){
        User userByTax;
        try{
            Integer tax = Integer.parseInt(taxnumber);
            userByTax =userRepository.findByTaxNumber(tax);
            if ((startDate!=null) && (endDate!=null) && (!taxnumber.isEmpty())){
                return (repairRepository.findBydayOfRepairBetweenAndUser(startDate,endDate,userByTax));
            }
            else if((startDate!=null) && (endDate==null) && (!taxnumber.isEmpty())){
                return (repairRepository.findByDayOfRepairAndUser(startDate,userByTax));
            }
            else if((startDate==null) && (endDate!=null) && (!taxnumber.isEmpty())){
                return (repairRepository.findByDayOfRepairAndUser(endDate,userByTax));
            }
            else{
                return(repairRepository.findByUser(userByTax));
            }

        }
        catch(NumberFormatException FormatEx){
            System.out.println("Tax number must be an integer");
            return null;
        }

    }
    private static <E> void addAllIfNotNull(List<E> list, Collection<? extends E> c) {
        if (c != null) {
            list.addAll(c);
        }
    }

}

