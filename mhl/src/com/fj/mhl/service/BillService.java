package com.fj.mhl.service;

import com.fj.mhl.dao.BillDAO;
import com.fj.mhl.dao.MultiTableBeanDAO;
import com.fj.mhl.domain.Bill;
import com.fj.mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/3 20:49    since 1.0.0
 */
public class BillService {
    //定义menuService
    private MenuService menuService=new MenuService();
    private DiningService diningService=new DiningService();
    //定义一个billDAO
    private BillDAO billDAO=new BillDAO();
    private MultiTableBeanDAO multiTableBeanDAO=new MultiTableBeanDAO();
    //编写点餐方法
    public boolean orderMenu(int menuId,int nums,int dingId){
        //生成一个账单号
        String billId = UUID.randomUUID().toString();
        //更新账单表
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, menuService.getMenu(menuId).getPrice() * nums, dingId);
        if (update<=0){
            return false;
        }
        //更新餐桌状态
        return  diningService.updateDiningState(dingId,"就餐中");
    }
    //返回账单信息
    public List<Bill> list(){
        return billDAO.queryMulti("select * from bill",Bill.class);
    }
    //查看某餐桌是否有未结账账单
    public boolean hasPayBillDining(int diningID){
        Bill bill = billDAO.querySinge("select * from bill where DiningId=? and state='未结账'", Bill.class, diningID);
        return bill!=null;
    }
    //修改bill表的状态 完成结账
    public boolean payBill(String state,int diningID){
        int update = billDAO.update("update bill set state=? where diningID=? and state='未结账'", state, diningID);
        if (update<=0){
            return false;
        }
        //修改dining表
        if (!diningService.updateDiningToFree(diningID)) {
            return false;
        }
        return true;
    }

    public List<MultiTableBean> list2(){
        return multiTableBeanDAO.queryMulti("select bill.*,name,price from bill,menu where bill.menuId=menu.id", MultiTableBean.class);
    }
}
