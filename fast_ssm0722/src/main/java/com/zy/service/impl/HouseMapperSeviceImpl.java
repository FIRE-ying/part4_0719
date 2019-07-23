package com.zy.service.impl;

import com.zy.mapper.HouseMapper;
import com.zy.pojo.House;
import com.zy.service.HouseMapperSevice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生活很好，记得微笑🙂
 */
@Service
public class HouseMapperSeviceImpl implements HouseMapperSevice {

   @Resource
   private HouseMapper houseMapper;


    @Override
    public int saveHouseInfo(House house) {
        return houseMapper.saveHouseInfo(house);
    }

    @Override
    public List<House> findAll() {
        return houseMapper.findAll();
    }
}
