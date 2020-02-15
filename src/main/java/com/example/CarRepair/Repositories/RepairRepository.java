package com.example.CarRepair.Repositories;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface RepairRepository extends CrudRepository<Repair,Long>{


    Repair save(Repair repair);
    void delete(Repair repair);

    Repair findByRepairID(Long repairID);
    List<Repair> findByUser(User user);
    List<Repair> findTop10ByOrderByDayOfRepair();
    List<Repair> findByPlateNumber(String plateNumber);
    List<Repair> findBydayOfRepairBetween(LocalDateTime dayOfRepair1, LocalDateTime dayOfRepair2);
    List<Repair> findBydayOfRepairBetweenAndPlateNumber(LocalDateTime dayOfRepair1, LocalDateTime dayOfRepair2, String plateNumber);
    List<Repair> findByDayOfRepair(LocalDateTime dayOfRepair);
    List<Repair> findByDayOfRepairAndPlateNumber(LocalDateTime dayOfRepair,String plateNumber);
    List<Repair> findByDayOfRepairAndUser(LocalDateTime dayOfRepair,User user);
    List<Repair> findBydayOfRepairBetweenAndUser(LocalDateTime dayOfRepair1, LocalDateTime dayOfRepair2, User user);
    List<Repair> findAll();
}
