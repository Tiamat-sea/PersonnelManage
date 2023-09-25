package org.tiamat.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tiamat.model.Department;
import org.tiamat.model.Employee;
import org.tiamat.service.DepartmentService;
import org.tiamat.service.EmployeeService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * 员工管理首页
     */
    @GetMapping("/employeeIndex")
    public String employeeIndex() {
        return "employee/employeeIndex";
    }

    /**
     * 获取员工信息，封装为json
     */
    @RequestMapping("employeeAll")
    @ResponseBody       //将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo employeeAll(Employee employee, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Employee> pageInfo = employeeService.queryEmployeeAll(employee, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    /**
     * 添加页面的跳转
     */
    @GetMapping("employeeAdd")
    public String employeeAdd() {
        return "employee/employeeAdd";
    }

    /**
     * 添加记录提交
     */
    @RequestMapping("addEmployeeSubmit")
    @ResponseBody
    public DataInfo addEmployeeSubmit(Employee employee) {
        employeeService.addEmployeeSubmit(employee);
        return DataInfo.ok();
    }

    /**
     * 根据id查询员工
     */
    @GetMapping("queryEmployeeById")
    public String queryEmployeeById(Integer id, Model model) {
        Employee employee = employeeService.queryEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/updateEmployee";
    }

    /**
     * 修改提交
     */
    @RequestMapping("updateEmployeeSubmit")
    @ResponseBody
    public DataInfo updateEmployeeSubmit(@RequestBody Employee employee) {
        employeeService.updateEmployeeSubmit(employee);
        return DataInfo.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("deleteEmployee")
    @ResponseBody
    public DataInfo deleteEmployee(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        System.out.println(ids);
        System.out.println(list);
        employeeService.deleteEmployeeByIds(list);
        return DataInfo.ok();
    }

    @RequestMapping("/findAllDepartment")
    @ResponseBody
    public List<Department> findAll() {
        PageInfo<Department> pageInfo = departmentService.queryDepartmentAll(null, 1, 100);
        return pageInfo.getList();
    }
}
