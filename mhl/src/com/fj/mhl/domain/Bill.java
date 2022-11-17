package com.fj.mhl.domain;

import java.time.LocalDateTime;

;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/3 20:46    since 1.0.0
 */
public class Bill {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer diningId;
    private LocalDateTime billDate;
    private String State;

    public Bill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDiningId() {
        return diningId;
    }

    public void setDiningId(Integer diningId) {
        this.diningId = diningId;
    }

    public LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Bill(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningId, LocalDateTime billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningId = diningId;
        this.billDate = billDate;
        State = state;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + billId +
                "\t\t" + menuId +
                "\t\t" + nums +
                "\t\t" + money +
                "\t\t" + diningId +
                "\t\t" + billDate +
                "\t\t"+State ;
    }
}
