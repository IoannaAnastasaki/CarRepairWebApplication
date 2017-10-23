package com.example.CarRepair.Repositories;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    List<Repair> findBydayOfRepairBetween(Date dayOfRepair1, Date dayOfRepair2);
    List<Repair> findByDayOfRepair(Date dayOfRepair);
}
