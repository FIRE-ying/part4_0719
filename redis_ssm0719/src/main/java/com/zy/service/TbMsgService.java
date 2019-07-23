package com.zy.service;

import com.zy.pojo.TbMsg;

import java.util.List;

public interface TbMsgService {
    List<TbMsg> findAll();

    int save(TbMsg tbMsg);
}
