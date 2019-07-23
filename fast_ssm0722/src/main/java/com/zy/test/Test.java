package com.zy.test;

import com.zy.mapper.HouseMapper;
import com.zy.pojo.House;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 生活很好，记得微笑🙂
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {

    @Resource
    private HouseMapper houseInfoMapper;

    @org.junit.Test
    public    void  test(){

        House info = new House();
        info.setTitle("好房出租");
        info.setAddress("北京海淀区");
        info.setPrice(10000);
        info.setImages("http://192.168.10.88:82/group1/M00/00/00/wKhSWF0yx0WAca9hAABdrZgsqUU496.jpg");

        int i =  houseInfoMapper.saveHouseInfo(info);
        System.err.println(i>0?"success":"fail");
    }

}
