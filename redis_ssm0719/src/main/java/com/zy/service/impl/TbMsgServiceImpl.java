package com.zy.service.impl;

import com.zy.mapper.TbMsgMapper;
import com.zy.pojo.TbMsg;
import com.zy.service.TbMsgService;
import com.zy.util.MyUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生活很好，记得微笑🙂
 */
@Service
public class TbMsgServiceImpl implements TbMsgService {
    @Resource
    private RedisTemplate<String,TbMsg> redisTemplate;
    @Resource
    private TbMsgMapper tbMsgMapper;

    @Override
    public List<TbMsg> findAll() {

        List<TbMsg> list = redisTemplate.opsForList().range(MyUtils.LIST_KEY, 0, -1);
        if (list!=null&&list.size()>0){
            System.out.println("缓存————"+list);
            return list;
        }else {
            System.out.println("数据库————");
            list = tbMsgMapper.findAll();
            Long l = redisTemplate.opsForList().rightPushAll(MyUtils.LIST_KEY, list);
            System.out.println("同步缓存");
        }

        return list;
    }

    @Override
    public int save(TbMsg tbMsg) {
        //1.数据库新增，缓存删除
        int i = tbMsgMapper.save(tbMsg);

        if (i>0){
            redisTemplate.delete(MyUtils.LIST_KEY);
            System.out.println("新增成功");
        }
        //2.数据库新增，再去新增缓存

        return i;
    }
}
