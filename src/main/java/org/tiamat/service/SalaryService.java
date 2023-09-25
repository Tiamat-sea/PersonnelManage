package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.Salary;

import java.util.List;

public interface SalaryService {
    /**
     * 查询所有工资信息（分页）
     */
    PageInfo<Salary> querySalaryAll(Salary salary, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addSalarySubmit(Salary salary);

    /**
     * 根据id查询（修改）
     */
    Salary querySalaryById(Integer id);

    /**
     * 修改提交
     */
    void updateSalarySubmit(Salary salary);

    /**
     * 删除
     */
    void deleteSalaryByIds(List<String> ids);
}
