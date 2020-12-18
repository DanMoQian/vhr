package org.javaboy.vhr.model.custom;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.javaboy.vhr.model.Employeeec;

import java.util.Date;

public class EmployeeecCustom extends Employeeec {

    private String name;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ecdate;


    @Override
    public Date getEcdate() {
        return ecdate;
    }

    @Override
    public void setEcdate(Date ecdate) {
        this.ecdate = ecdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EmployeeecCustom{" +
                "name='" + name + '\'' +
                '}';
    }
}
