package com.fj.mhl.service;

import com.fj.mhl.dao.DiningDAO;
import com.fj.mhl.domain.Dining;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/2 20:56    since 1.0.0
 */
public class DiningService {
    //定义一个diningDAO对象
    DiningDAO diningDAO =new DiningDAO();
    //返回所有餐桌信息
    public List<Dining> list(){
        return diningDAO.queryMulti("select * from dining",Dining.class);
    }

    //是否就餐或者已预订
    public Dining getDiningById(int id){
        return diningDAO.querySinge("select * from dining where id=?",Dining.class,id);
    }
    //如果餐桌可以预定 调用方法对齐更新
    public boolean  orderDining(int id,String orderName, String orderTel){
        int update = diningDAO.update("update dining set state='已预订',orderName=? ,orderTel=? where id=?", orderName, orderTel,id);
        return update>0;
    }
    //更新餐桌状态
    public boolean updateDiningState(int id,String state){
        int update = diningDAO.update("update dining set state=? where id=?", state, id);
        return update>0;
    }
    //将指定餐桌设置为初始状态
    public boolean updateDiningToFree(int id){
        int update = diningDAO.update("update dining set state='空',orderName='',orderTel='' where id=?", id);
        return update>0;
    }
}
