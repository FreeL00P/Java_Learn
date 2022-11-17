package com.fj.servlets;

import com.fj.fruit.base.FruitDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/28 10:38    since 1.0.0
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        Integer price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark=req.getParameter("remark");

        System.out.println("fname="+fname);
        System.out.println("price="+price);
        System.out.println("fcount="+fcount);
        System.out.printf("remark="+remark);
        insert(fname,price,fcount,remark);

    }
    public void insert(String fname,Integer price,Integer fcount,String remark){
        FruitDAO fruitDAO=new FruitDAO();
        String sql="insert into fruit (fid,fname,price,fcount,remark) values(null,?,?,?,?);";
        fruitDAO.update(sql,fname,price,fcount,remark);
    }
}
