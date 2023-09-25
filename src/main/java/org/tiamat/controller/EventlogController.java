package org.tiamat.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tiamat.model.Eventlog;
import org.tiamat.service.EventlogService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class EventlogController {
    @Autowired
    private EventlogService eventlogService;

    /**
     * 日志管理首页
     */
    @GetMapping("/eventlogIndex")
    public String employeeIndex() {
        return "eventlog/eventlogIndex";
    }

    @RequestMapping("eventlogAll")
    @ResponseBody       //将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo eventlogAll(Eventlog eventlog, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Eventlog> pageInfo = eventlogService.queryEventlogAll(eventlog, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    @GetMapping("eventlogAdd")
    public String eventlogAdd() {
        return "eventlog/eventlogAdd";
    }

    @RequestMapping("addEventlogSubmit")
    @ResponseBody
    public DataInfo addEventlogSubmit(Eventlog eventlog) {
        eventlogService.addEventlogSubmit(eventlog);
        return DataInfo.ok();
    }

    @GetMapping("queryEventlogById")
    public String queryEventlogById(Integer id, Model model) {
        Eventlog eventlog = eventlogService.queryEventlogById(id);
        model.addAttribute("eventlog", eventlog);
        return "eventlog/updateEventlog";
    }

    @RequestMapping("updateEventlogSubmit")
    @ResponseBody
    public DataInfo updateEventlogSubmit(@RequestBody Eventlog eventlog) {
        eventlogService.updateEventlogSubmit(eventlog);
        return DataInfo.ok();
    }

    @RequestMapping("deleteEventlog")
    @ResponseBody
    public DataInfo deleteEventlog(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        eventlogService.deleteEventlogByIds(list);
        return DataInfo.ok();
    }
}