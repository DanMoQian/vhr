package org.javaboy.vhr.mapper.custom;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.mapper.EmployeeecMapper;
import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.custom.EmployeeecCustom;

import java.util.List;

public interface EmployeeecMapperCustom extends EmployeeecMapper {

    List<Employeeec> selectAllByPage(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

    int getAllCount();

}
