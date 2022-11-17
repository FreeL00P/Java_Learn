package com.fj.utils;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/30 9:31    since 1.0.0
 */
public class StringUtil {
    //判断字符串是否为空
    public  static boolean isEmpty(String str){
        return  str==null||"".equals(str);
    }
    public  static boolean isNotEmpty(String str){
       return !isEmpty(str);
    }
}
