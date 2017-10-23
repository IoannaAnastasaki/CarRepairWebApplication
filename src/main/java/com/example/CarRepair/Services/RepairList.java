package com.example.CarRepair.Services;

import com.example.CarRepair.Model.RepairRow;

import java.util.List;

public interface RepairList
{

    public List<RepairRow> findTop10ByOrderByDayOfRepair();
}
