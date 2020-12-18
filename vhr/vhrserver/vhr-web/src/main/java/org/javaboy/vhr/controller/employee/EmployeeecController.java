package org.javaboy.vhr.controller.employee;

import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.service.EmployeeecService;
import org.javaboy.vhr.service.impl.EmployeeecServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/employeeec/basic")
public class EmployeeecController {

    @Autowired
    private EmployeeecService employeeecService;

    @GetMapping("/")
    public RespPageBean getEmployeeecByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        return employeeecService.getEmployeeecByPage(page, pageSize);
    }

    @PostMapping("/")
    public RespBean addEmployeeec(Employeeec employeeec){
        Integer re = employeeecService.addEmployeeec(employeeec);
        if (re == 1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");

    }

}
