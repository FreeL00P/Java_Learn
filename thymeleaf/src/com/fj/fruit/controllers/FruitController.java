package com.fj.fruit.controllers;

import com.fj.fruit.base.FruitDAO;
import com.fj.fruit.pojo.Fruit;
import com.fj.fruit.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/31 12:46    since 1.0.0
 */
//@WebServlet("/fruit.do")
public class FruitController  {
    FruitDAO fruitDAO=new FruitDAO();
    private String index(HttpServletRequest req,String oper,String keyword,Integer pageNo){
        HttpSession session=req.getSession();
        if (pageNo==null) pageNo=1;
        if(StringUtil.isNotEmpty(oper)||"search".equals(oper)) {
            //说明是点击表单发送过来的请求
            //此时 pageNo应该还原成1 keyword从请求参数中获取
            pageNo = 1;
            if(StringUtil.isEmpty(keyword)){
                keyword="";
            }
            session.setAttribute("keyword",keyword);
        }else {
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj!=null) {
                keyword=(String) keywordObj;
            }else {
                keyword="";
            }
        }
        session.setAttribute("pageNo",pageNo);
        FruitDAO fruitDAO=new FruitDAO();
        List<Fruit> fruitList = fruitDAO.queryMulti("select * from fruit where fname like ? or remark like ? limit ?,5;", Fruit.class,"%"+keyword+"%","%"+keyword+"%",(pageNo-1)*5);
        Object counts= fruitDAO.queryScalar("select count(*) from fruit where fname like ? or remark like ?;","%"+keyword+"%","%"+keyword+"%");
        Integer count=Integer.parseInt(counts.toString());
        int pageCount=(count+5-1)/5;
        session.setAttribute("pageCount",pageCount);
        session.setAttribute("fruitList",fruitList);
        return "index";
    }

    private String  add(Integer fid,String fname,Integer price,Integer fcount,String remark){
        String sql="insert into fruit (fid,fname,price,fcount,remark) values(null,?,?,?,?);";
        fruitDAO.update(sql,fname,price,fcount,remark);
        return "redirect:fruit.do";
    }

    private String del(Integer fid){
        if(fid!=null){
            String sql="delete from fruit where fid=?;";
            fruitDAO.update(sql,fid);
            return "redirect:fruit.do";
        }
        return "error";
    }

    private String edit(HttpServletRequest req,Integer fid){
        if(fid!=null){
            Fruit fruit = fruitDAO.querySinge("select * from fruit where fid=?;", Fruit.class, fid);
            req.setAttribute("fruit",fruit);
            //super.processTemplate("edit",req,resp);
            return "edit";
        }
        return "error";
    }

    private String update(Integer fid,String fname,Integer price,Integer fcount,String remark)  {
        String sql="update fruit set fname=?,price=?,fcount=?,remark=? where fid=?;";
        fruitDAO.update(sql,fname,price,fcount,remark,fid);
        //4.资源跳转
        //super.processTemplate("index",request,response);
        //request.getRequestDispatcher("index.html").forward(request,response);
        //此处需要重定向，目的是重新给IndexServlet发请求，重新获取furitList，然后覆盖到session中，这样index.html页面上显示的session中的数据才是最新的
        // resp.sendRedirect("fruit.do");
        return "redirect:fruit.do";
    }
}
