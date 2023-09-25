package org.tiamat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiamat.mapper.SalaryMapper;
import org.tiamat.model.Salary;
import org.tiamat.service.SalaryService;

import java.util.List;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public PageInfo<Salary> querySalaryAll(Salary salary, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Salary> salaryList = salaryMapper.querySalaryAll(salary);
        return new PageInfo<>(salaryList);
    }

    @Override
    public void addSalarySubmit(Salary salary) {
        salaryMapper.insert(salary);
    }

    @Override
    public Salary querySalaryById(Integer id) {
        return salaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateSalarySubmit(Salary salary) {
        salaryMapper.updateByPrimaryKey(salary);
    }

    @Override
    public void deleteSalaryByIds(List<String> ids) {
        for (String id : ids) {
            salaryMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
