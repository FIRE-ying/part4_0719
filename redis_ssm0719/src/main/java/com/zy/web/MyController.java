package com.zy.web;

import com.zy.pojo.TbMsg;
import com.zy.service.TbMsgService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生活很好，记得微笑🙂
 */
@RestController
public class MyController {

    @Resource
    private TbMsgService service;

    @RequestMapping("/findall")
    public List<TbMsg> findall(){

        List<TbMsg> li = service.findAll();
        return li;
    }

    @RequestMapping("/save")
    public int save(TbMsg tbMsg){

        int i = service.save(tbMsg);
        return i;
    }
}
