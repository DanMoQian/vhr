package org.javaboy.vhr;

import org.javaboy.vhr.service.EmployeeecService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VhrApplicationTests {

    @Autowired
    private EmployeeecService employeeecService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getEmployeeByPage(){
        System.out.println(employeeecService.getEmployeeecByPage(0, 10));
    }

}
