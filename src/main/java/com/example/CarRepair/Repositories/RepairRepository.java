package com.example.CarRepair.Repositories;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface RepairRepository extends CrudRepository<Repair,Long>{
    //description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber


    Repair save(Repair repair);
    void delete(Repair repair);

    //List<Repair> findByUser(Long userId);
    List<Repair> findByUser(User user);
    List<Repair> findTop10ByOrderByDayOfRepair();
    List<Repair> findByPlateNumber(String plateNumber);
    //If there has been erro i make it LocalDateTime
    List<Repair> findBydayOfRepairBetween(LocalDateTime dayOfRepair1, LocalDateTime dayOfRepair2);
    List<Repair> findBydayOfRepairBetweenAndUserAndPlateNumber(LocalDateTime dayOfRepair1, LocalDateTime dayOfRepair2,User user, String plateNumber);
    List<Repair> findByDayOfRepair(LocalDateTime dayOfRepair);
    List<Repair> findByUserAndPlateNumber(User user,String plateNumber);
    List<Repair> findAll();
}
