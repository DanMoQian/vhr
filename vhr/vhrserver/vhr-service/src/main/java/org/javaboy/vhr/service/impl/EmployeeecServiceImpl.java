package org.javaboy.vhr.service.impl;

import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.mapper.custom.EmployeeecMapperCustom;
import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.service.EmployeeecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeecServiceImpl implements EmployeeecService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private EmployeeecMapperCustom employeeecMapperCustom;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public RespPageBean getEmployeeecByPage(Integer page, Integer size) {

        List<Employeeec> employeeecList = employeeecMapperCustom.selectAllByPage(page, size);
        int count = employeeecMapperCustom.getAllCount();
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(employeeecList);
        respPageBean.setTotal(Long.valueOf(count));
        return respPageBean;
    }

    @Override
    public Integer addEmployeeec(Employeeec employeeec) {
        //数据校验
        if (employeeec == null && employeeec.getEid() == null && employeeec.getEcpoint()==null && employeeec.getEcdate()==null)
            throw new RuntimeException("填写错误");
        Employeeec oldEmployeeec = employeeecMapperCustom.selectByPrimaryKey(employeeec.getId());
        if (oldEmployeeec == null){//该员工未出现奖惩情况 就默认100加分数点
            employeeec.setRemark(100 + employeeec.getEcpoint()+"");
        }else {//该员工出现过奖惩情况 先查询再加入
            employeeec.setRemark(oldEmployeeec.getEcpoint() + employeeec.getEcpoint()+"");
        }
        //当员工的分数为零将信息反馈给人事部的所有人

        return employeeecMapperCustom.insert(employeeec);
    }
}
