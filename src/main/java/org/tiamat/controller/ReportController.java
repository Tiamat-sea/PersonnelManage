package org.tiamat.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tiamat.model.Report;
import org.tiamat.service.ReportService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 报表管理首页
     */
    @GetMapping("/reportIndex")
    public String employeeIndex() {
        return "report/reportIndex";
    }

    @RequestMapping("reportAll")
    @ResponseBody       //将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo reportAll(Report report, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Report> pageInfo = reportService.queryReportAll(report, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    @GetMapping("reportAdd")
    public String reportAdd() {
        return "report/reportAdd";
    }

    @RequestMapping("addReportSubmit")
    @ResponseBody
    public DataInfo addReportSubmit(Report report) {
        reportService.addReportSubmit(report);
        return DataInfo.ok();
    }

    @GetMapping("queryReportById")
    public String queryReportById(Integer id, Model model) {
        Report report = reportService.queryReportById(id);
        model.addAttribute("report", report);
        return "report/updateReport";
    }

    @RequestMapping("updateReportSubmit")
    @ResponseBody
    public DataInfo updateReportSubmit(@RequestBody Report report) {
        reportService.updateReportSubmit(report);
        return DataInfo.ok();
    }

    @RequestMapping("deleteReport")
    @ResponseBody
    public DataInfo deleteReport(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        reportService.deleteReportByIds(list);
        return DataInfo.ok();
    }
}
