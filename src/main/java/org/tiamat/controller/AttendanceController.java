package org.tiamat.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tiamat.model.Attendance;
import org.tiamat.service.AttendanceService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    /**
     * 考勤管理首页
     */
    @GetMapping("/attendanceIndex")
    public String employeeIndex() {
        return "attendance/attendance/attendanceIndex";
    }

    @RequestMapping("attendanceAll")
    @ResponseBody       //将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo attendanceAll(Attendance attendance, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Attendance> pageInfo = attendanceService.queryAttendanceAll(attendance, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    @GetMapping("attendanceAdd")
    public String attendanceAdd() {
        return "attendance/attendance/attendanceAdd";
    }

    @RequestMapping("addAttendanceSubmit")
    @ResponseBody
    public DataInfo addAttendanceSubmit(Attendance attendance) {
        attendanceService.addAttendanceSubmit(attendance);
        return DataInfo.ok();
    }

    @GetMapping("queryAttendanceById")
    public String queryAttendanceById(Integer id, Model model) {
        Attendance attendance = attendanceService.queryAttendanceById(id);
        model.addAttribute("attendance", attendance);
        return "attendance/attendance/updateAttendance";
    }

    @RequestMapping("updateAttendanceSubmit")
    @ResponseBody
    public DataInfo updateAttendanceSubmit(@RequestBody Attendance attendance) {
        attendanceService.updateAttendanceSubmit(attendance);
        return DataInfo.ok();
    }

    @RequestMapping("deleteAttendance")
    @ResponseBody
    public DataInfo deleteAttendance(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        attendanceService.deleteAttendanceByIds(list);
        return DataInfo.ok();
    }
}
