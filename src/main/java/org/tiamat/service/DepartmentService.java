package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 查询所有部门（分页）
     */
    PageInfo<Department> queryDepartmentAll(Department department, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addDepartmentSubmit(Department department);

    /**
     * 根据id查询（修改）
     */
    Department queryDepartmentById(Integer id);

    /**
     * 修改提交
     */
    void updateDepartmentSubmit(Department department);

    /**
     * 删除
     */
    void deleteDepartmentByIds(List<String> ids);
}
