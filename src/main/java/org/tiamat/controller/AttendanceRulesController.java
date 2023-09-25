package org.tiamat.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tiamat.model.AttendanceRules;
import org.tiamat.service.AttendanceRulesService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class AttendanceRulesController {
    @Autowired
    private AttendanceRulesService attendanceRulesService;

    /**
     * 考勤规则管理首页
     */
    @GetMapping("/attendanceRulesIndex")
    public String employeeIndex() {
        return "attendance/attendanceRules/attendanceRulesIndex";
    }

    @RequestMapping("/attendanceRulesAll")
    @ResponseBody       //将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo attendanceRulesAll(AttendanceRules attendanceRules, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<AttendanceRules> pageInfo = attendanceRulesService.queryAttendanceRulesAll(attendanceRules, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    @GetMapping("/attendanceRulesAdd")
    public String attendanceRulesAdd() {
        return "attendance/attendanceRules/attendanceRulesAdd";
    }

    @RequestMapping("/addAttendanceRulesSubmit")
    @ResponseBody
    public DataInfo addAttendanceRulesSubmit(AttendanceRules attendanceRules) {
        System.out.println("arrive!");
        attendanceRulesService.addAttendanceRulesSubmit(attendanceRules);
        return DataInfo.ok();
    }

    @GetMapping("/queryAttendanceRulesById")
    public String queryAttendanceRulesById(Integer id, Model model) {
        AttendanceRules attendanceRules = attendanceRulesService.queryAttendanceRulesById(id);
        model.addAttribute("attendanceRules", attendanceRules);
        return "attendance/attendanceRules/updateAttendanceRules";
    }

    @RequestMapping("/updateAttendanceRulesSubmit")
    @ResponseBody
    public DataInfo updateAttendanceRulesSubmit(@RequestBody AttendanceRules attendanceRules) {
        attendanceRulesService.updateAttendanceRulesSubmit(attendanceRules);
        return DataInfo.ok();
    }

    @RequestMapping("/deleteAttendanceRules")
    @ResponseBody
    public DataInfo deleteAttendanceRules(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        attendanceRulesService.deleteAttendanceRulesByIds(list);
        return DataInfo.ok();
    }
}
