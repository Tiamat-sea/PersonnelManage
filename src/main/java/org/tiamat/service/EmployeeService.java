package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 查询所有员工（分页）
     */
    PageInfo<Employee> queryEmployeeAll(Employee employee, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addEmployeeSubmit(Employee employee);

    /**
     * 根据id查询（修改）
     */
    Employee queryEmployeeById(Integer id);

    /**
     * 修改提交
     */
    void updateEmployeeSubmit(Employee employee);

    /**
     * 删除
     */
    void deleteEmployeeByIds(List<String> ids);

    /**
     * 根据用户名和密码查询用户信息
     */
    Employee queryEmployeeByNameAndPassword(String username, String password);
}
