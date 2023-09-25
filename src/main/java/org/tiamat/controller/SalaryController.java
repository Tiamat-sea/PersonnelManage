package org.tiamat.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tiamat.model.Salary;
import org.tiamat.service.SalaryService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    /**
     * 薪资管理首页
     */
    @GetMapping("/salaryIndex")
    public String employeeIndex() {
        return "salary/salaryIndex";
    }

    @RequestMapping("salaryAll")
    @ResponseBody       //将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo salaryAll(Salary salary, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Salary> pageInfo = salaryService.querySalaryAll(salary, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    @GetMapping("salaryAdd")
    public String salaryAdd() {
        return "salary/salaryAdd";
    }

    @RequestMapping("addSalarySubmit")
    @ResponseBody
    public DataInfo addSalarySubmit(Salary salary) {
        salaryService.addSalarySubmit(salary);
        return DataInfo.ok();
    }

    @GetMapping("querySalaryById")
    public String querySalaryById(Integer id, Model model) {
        Salary salary = salaryService.querySalaryById(id);
        model.addAttribute("salary", salary);
        return "salary/updateSalary";
    }

    @RequestMapping("updateSalarySubmit")
    @ResponseBody
    public DataInfo updateSalarySubmit(@RequestBody Salary salary) {
        salaryService.updateSalarySubmit(salary);
        return DataInfo.ok();
    }

    @RequestMapping("deleteSalary")
    @ResponseBody
    public DataInfo deleteSalary(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        salaryService.deleteSalaryByIds(list);
        return DataInfo.ok();
    }
}