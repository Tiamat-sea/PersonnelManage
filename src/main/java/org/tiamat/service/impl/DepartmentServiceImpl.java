package org.tiamat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiamat.mapper.DepartmentMapper;
import org.tiamat.model.Department;
import org.tiamat.service.DepartmentService;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public PageInfo<Department> queryDepartmentAll(Department department, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Department> departmentList = departmentMapper.queryDepartmentAll(department);
        return new PageInfo<>(departmentList);
    }

    @Override
    public void addDepartmentSubmit(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public Department queryDepartmentById(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateDepartmentSubmit(Department department) {
        departmentMapper.updateDepartmentSubmit(department);
    }

    @Override
    public void deleteDepartmentByIds(List<String> ids) {
        for (String id : ids) {
            departmentMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
