package org.tiamat.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tiamat.model.Department;
import org.tiamat.service.DepartmentService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 部门管理首页
     */
    @GetMapping("/departmentIndex")
    public String employeeIndex() {
        return "department/departmentIndex";
    }

    @RequestMapping("/departmentAll")
    @ResponseBody       //将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo departmentAll(Department department, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Department> pageInfo = departmentService.queryDepartmentAll(department, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    @GetMapping("/departmentAdd")
    public String departmentAdd() {
        return "department/departmentAdd";
    }

    @RequestMapping("/addDepartmentSubmit")
    @ResponseBody
    public DataInfo addDepartmentSubmit(Department department) {
        departmentService.addDepartmentSubmit(department);
        return DataInfo.ok();
    }

    @GetMapping("/queryDepartmentById")
    public String queryDepartmentById(Integer id, Model model) {
        Department department = departmentService.queryDepartmentById(id);
        model.addAttribute("department", department);
        return "department/updateDepartment";
    }

    @RequestMapping("/updateDepartmentSubmit")
    @ResponseBody
    public DataInfo updateDepartmentSubmit(@RequestBody Department department) {
        departmentService.updateDepartmentSubmit(department);
        return DataInfo.ok();
    }

    @RequestMapping("/deleteDepartment")
    @ResponseBody
    public DataInfo deleteDepartment(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        departmentService.deleteDepartmentByIds(list);
        return DataInfo.ok();
    }
}
