package com.fj.mhl.service;

import com.fj.mhl.dao.EmployeeDAO;
import com.fj.mhl.domain.Employee;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/2 15:34    since 1.0.0
 * 对Employee表的各种操作 通过调用EmployeeDAO完成
 */
public class EmployeeService {
    private EmployeeDAO employeeDAO=new EmployeeDAO();
    //根据empId和pwd返回一个Employee对象
    public Employee getEmployeeByIdAndPwd(String empId,String pwd){
        Employee employee = employeeDAO.querySinge("select * from Employee where empId=? and pwd=md5(?)", Employee.class, empId,pwd);
        return employee;
    }
}
