package com.zy.service;

import com.zy.pojo.House;

import java.util.List;

public interface HouseMapperSevice {

    public  int saveHouseInfo(House house);

    public List<House> findAll();
}
