package org.tiamat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiamat.mapper.EmployeeMapper;
import org.tiamat.model.Employee;
import org.tiamat.service.EmployeeService;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<Employee> queryEmployeeAll(Employee employee, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Employee> employeeList = employeeMapper.queryEmployeeAll(employee);
        return new PageInfo<>(employeeList);
    }

    @Override
    public void addEmployeeSubmit(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public Employee queryEmployeeById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateEmployeeSubmit(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void deleteEmployeeByIds(List<String> ids) {
        for (String id : ids) {
            employeeMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }

    @Override
    public Employee queryEmployeeByNameAndPassword(String username, String password) {
        return employeeMapper.queryEmployeeByNameAndPassword(username, password);
    }
}
