package com.fj.dao_.test;

import com.fj.dao_.dao.BiliDAO;
import com.fj.dao_.domain.Bilibili;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/1 14:46    since 1.0.0
 */
public class TestDAO {
    @Test
    public void testBiliDAO(){
        BiliDAO biliDAO = new BiliDAO();
        //1 查询
        List<Bilibili> bilibili = biliDAO.queryMulti("select * from 2021_10月b站热播视频排行数据 where `rank`  >= ?", Bilibili.class, 1);
        for (Bilibili bili:bilibili) {
            System.out.println(bili);
        }
        //查询单行结果
        Bilibili bili1 = (Bilibili) biliDAO.querySinge("select * from 2021_10月b站热播视频排行数据 where `rank`  = ?", Bilibili.class, 1);
        System.out.println(bili1);
        //单行单列值
        Object bili2 =biliDAO.queryScalar("select `rank` from 2021_10月b站热播视频排行数据 where `rank`  = ?", 1);
        System.out.println(bili2);
    }
}
