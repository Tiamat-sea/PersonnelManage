package org.tiamat.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tiamat.model.Overtime;
import org.tiamat.service.OvertimeService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class OvertimeController {
    @Autowired
    private OvertimeService overtimeService;

    /**
     * 加班管理首页
     */
    @GetMapping("/overtimeIndex")
    public String employeeIndex() {
        return "overtime/overtimeIndex";
    }

    @RequestMapping("overtimeAll")
    @ResponseBody       //将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo overtimeAll(Overtime overtime, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Overtime> pageInfo = overtimeService.queryOvertimeAll(overtime, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    @GetMapping("overtimeAdd")
    public String overtimeAdd() {
        return "overtime/overtimeAdd";
    }

    @RequestMapping("addOvertimeSubmit")
    @ResponseBody
    public DataInfo addOvertimeSubmit(Overtime overtime) {
        overtimeService.addOvertimeSubmit(overtime);
        return DataInfo.ok();
    }

    @GetMapping("queryOvertimeById")
    public String queryOvertimeById(Integer id, Model model) {
        Overtime overtime = overtimeService.queryOvertimeById(id);
        model.addAttribute("overtime", overtime);
        return "overtime/updateOvertime";
    }

    @RequestMapping("updateOvertimeSubmit")
    @ResponseBody
    public DataInfo updateOvertimeSubmit(@RequestBody Overtime overtime) {
        overtimeService.updateOvertimeSubmit(overtime);
        return DataInfo.ok();
    }

    @RequestMapping("deleteOvertime")
    @ResponseBody
    public DataInfo deleteOvertime(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        overtimeService.deleteOvertimeByIds(list);
        return DataInfo.ok();
    }
}
