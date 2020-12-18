package org.javaboy.vhr.service;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;

import java.util.Date;

public interface EmployeeecService {

    public RespPageBean getEmployeeecByPage( Integer page, Integer size);

    public Integer addEmployeeec(Employeeec employeeec);

}
