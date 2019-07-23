package com.zy.mapper;

import com.zy.pojo.House;

import java.util.List;

public interface HouseMapper {


    public  int saveHouseInfo(House house);

    public List<House> findAll();
}
