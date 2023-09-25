package org.tiamat.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tiamat.model.Leave;
import org.tiamat.service.LeaveService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    /**
     * 休假管理首页
     */
    @GetMapping("/leaveIndex")
    public String employeeIndex() {
        return "leave/leaveIndex";
    }

    @RequestMapping("leaveAll")
    @ResponseBody       //将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo leaveAll(Leave leave, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Leave> pageInfo = leaveService.queryLeaveAll(leave, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    @GetMapping("leaveAdd")
    public String leaveAdd() {
        return "leave/leaveAdd";
    }

    @RequestMapping("addLeaveSubmit")
    @ResponseBody
    public DataInfo addLeaveSubmit(Leave leave) {
        leaveService.addLeaveSubmit(leave);
        return DataInfo.ok();
    }

    @GetMapping("queryLeaveById")
    public String queryLeaveById(Integer id, Model model) {
        Leave leave = leaveService.queryLeaveById(id);
        model.addAttribute("leave", leave);
        return "leave/updateLeave";
    }

    @RequestMapping("updateLeaveSubmit")
    @ResponseBody
    public DataInfo updateLeaveSubmit(@RequestBody Leave leave) {
        leaveService.updateLeaveSubmit(leave);
        return DataInfo.ok();
    }

    @RequestMapping("deleteLeave")
    @ResponseBody
    public DataInfo deleteLeave(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        leaveService.deleteLeaveByIds(list);
        return DataInfo.ok();
    }
}
