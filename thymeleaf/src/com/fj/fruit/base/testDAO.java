package com.fj.fruit.base;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/28 13:04    since 1.0.0
 */
public class testDAO {
    public static void main(String[] args) {
        FruitDAO fruitDAO=new FruitDAO();
        String fname="1";
        String remark="1";
        String priceStr="1";
        String fcountStr="1";
        Integer price = Integer.parseInt(priceStr);
        Integer fcount = Integer.parseInt(fcountStr);
        String sql="insert into fruit (fid,fname,price,fcount,remark) values(null,?,?,?,?);";
        fruitDAO.update(sql,fname,price,fcount,remark);
    }
}
