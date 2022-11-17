package com.fj.mhl.service;

import com.fj.mhl.dao.MenuDAO;
import com.fj.mhl.domain.Menu;
import java.util.List;
/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/3 20:17    since 1.0.0
 */
public class MenuService {
    private MenuDAO menuDao=new MenuDAO();
    //返回所有菜品
    public List<Menu> list(){
        return menuDao.queryMulti("select * from menu",Menu.class);
    }
    //根据id返回menu对象
    public Menu getMenu(int id){
        return menuDao.querySinge("select * from menu where id=?",Menu.class,id);
    }
}
