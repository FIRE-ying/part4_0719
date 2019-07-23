package com.zy.mapper;

import com.zy.pojo.TbMsg;

import java.util.List;

public interface TbMsgMapper {
    List<TbMsg> findAll();

    int save(TbMsg tbMsg);
}
