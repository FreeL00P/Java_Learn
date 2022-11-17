package com.fj.mhl.view;

import com.fj.mhl.domain.*;
import com.fj.mhl.service.BillService;
import com.fj.mhl.service.DiningService;
import com.fj.mhl.service.EmployeeService;
import com.fj.mhl.service.MenuService;
import com.fj.mhl.utils.Utility;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/2 14:43    since 1.0.0
 *
 */
public class MHLView {
    public static void main(String[] args) {
        new MHLView().mainView();
    }
    //显示主菜单
    private boolean loop=true;//控制是否退出菜单
    private String key;
    //调用属性
    private EmployeeService employeeService=new EmployeeService();
    private DiningService diningService=new DiningService();
    private MenuService menuService=new MenuService();
    private BillService billService=new BillService();
    public void mainView(){
        while (loop){
            System.out.println("==========满汉楼==========");
            System.out.println("\t\t 1 登陆满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.println("请输入你的选择：");
            key= Utility.readString(1);
            switch (key){
                case "1":
                    System.out.println("请输入员工号：");
                    String empId=Utility.readString(50);
                    System.out.println("请输入密码：");
                    String pwd=Utility.readString(50);
                    //到数据库判断
                    Employee employee= employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if (employee!=null){//说明存在该用户
                        System.out.println("登陆成功");
                        //显示二级菜单
                        while(loop){
                            System.out.println("\n==========满汉楼二级菜单==========");
                            System.out.println("\t\t 1 显示餐组状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出满汉楼");
                            System.out.println("请输入你的选择");
                            key=Utility.readString(1);
                            switch (key){
                                case "1":
                                    listDining();
                                    break;
                                case "2":
                                    orderDining();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    System.out.println("退出满汉楼");
                                    loop=false;
                                    break;
                                default:
                                    System.out.println("你的输入有误");
                            }
                        }
                    }else{
                        System.out.println("登陆失败");
                    }
                    break;
                case "2":
                    System.out.println("退出满汉楼");
                    loop=false;
                    break;
                default:
                    System.out.println("你的输入有误。");

            }
        }
    }

    //显示所有餐桌状态
    public void listDining(){
        List<Dining> lists = diningService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (Dining list:lists) {
            System.out.println(list);
        }
    }
    //完成预定
    public void orderDining(){
        System.out.println("请输入预定座位(-1退出)");
        int id=Utility.readInt();
        if (id==-1){//输入-1退出预定
            System.out.println("==========取消预定==========");
            return;
        }
        char key=Utility.readConfirmSelection();
        if (key=='Y'){
            //根据id返回对应的dining对象 如果为空则不存在
            Dining dining = diningService.getDiningById(id);
            if (dining==null){
                System.out.println("==========预定的餐桌不存在==========");
                return;
            }
            //判断预定餐桌状态
            if (!"空".equals(dining.getState())){
                System.out.println(id+"该座位已经被预定了,请选择其他座位");
                return;
            }

            System.out.println("输入预定人名字：");
            String orderName=Utility.readString(10);
            System.out.println("请输入预定人电话：");
            String orderTal=Utility.readString(11);
            //预定

            if (diningService.orderDining(id,orderName,orderTal)){
                System.out.println("==========预定成功==========");
            }else {
                System.out.println("==========预定失败==========");
            }
        }else {
            System.out.println("==========取消预定==========");
        }
    }
    
    //显示所有菜品
    public  void listMenu(){
        List<Menu> list = menuService.list();
        System.out.println("\n菜品编号\t\t菜品名称\t\t类别\t\t价格");
        for (Menu menu:list) {
            System.out.println(menu);
        }
    }
    //完成点餐
    public void orderMenu(){
        System.out.println("==========点餐服务==========");
        System.out.println("请输入餐桌号号(-1退出)：");
        int orderDiningId=Utility.readInt();
        if (orderDiningId==-1){
            System.out.println("==========取消点餐==========");
            return;
        }
        System.out.println("请输入点餐的菜品号(-1退出)：");
        int orderMenuId=Utility.readInt();
        if (orderMenuId==-1){
            System.out.println("==========取消点餐==========");
            return;
        }

        System.out.println("请输入点餐的菜品量(-1退出)");
        int orderNums=Utility.readInt();
        if (orderNums==-1){
            System.out.println("==========取消点餐==========");
            return;
        }
        //验证餐桌号是否存在
        Dining dining = diningService.getDiningById(orderDiningId);
        if (dining==null){
            System.out.println("==========餐桌号有误==========");
            return;
        }
        //验证菜品编号是否正确
        Menu menu = menuService.getMenu(orderMenuId);
        if (menu==null){
            System.out.println("==========菜品号不存在==========");
        }
        //点餐
        boolean b = billService.orderMenu(orderMenuId, orderNums, orderDiningId);
        if (b){
            System.out.println("==========点餐成功==========");
        }else {
            System.out.println("==========点餐失败==========");
        }
    }
    //显示账单信息
    public void listBill(){
//        List<Bill> bills = billService.list();
//        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
//        for (Bill bill : bills) {
//            System.out.println(bill);
//        }
//        System.out.println("==========显示完毕==========");
        List<MultiTableBean> bills = billService.list2();
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态\t\t菜品名\t\t价格");
        for (MultiTableBean bill : bills) {
            System.out.println(bill);
        }
        System.out.println("==========显示完毕==========");
    }
    //结账
    public void payBill(){
        System.out.println("==========结账服务==========");
        System.out.println("请输入餐桌号号(-1退出)：");
        int orderDiningId=Utility.readInt();
        if (orderDiningId==-1){
            System.out.println("==========取消结账==========");
            return;
        }
        //验证餐桌是否存在
        Dining dining = diningService.getDiningById(orderDiningId);
        if (dining==null){
            System.out.println("==========结账的餐桌不存在==========");
            return;
        }
        //验证餐桌是否需要结账
        if (!billService.hasPayBillDining(orderDiningId)){
            System.out.println("==========该餐桌没有未结账账单========");
            return;
        }
        System.out.println("选择结账方式(微信/支付宝/现金)");
        String payMode = Utility.readString(20,"");//回车默认值""
        if ("".equals(payMode)){
            System.out.println("==========取消结账==========");
            return;
        }
        char key = Utility.readConfirmSelection();
        if (key=='Y'){
            if (billService.payBill(payMode, orderDiningId)){
                System.out.println("==========结账成功==========");
            }else {
                System.out.println("==========结账失败==========");
            }
        }else {
            System.out.println("==========取消结账==========");
        }
    }
}
