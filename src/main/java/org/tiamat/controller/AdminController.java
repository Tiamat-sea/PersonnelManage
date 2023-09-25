package org.tiamat.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tiamat.model.Admin;
import org.tiamat.service.AdminService;
import org.tiamat.utils.DataInfo;

import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/adminIndex")
    public String adminIndex() {
        return "admin/adminIndex";
    }

    @RequestMapping("/adminAll")
    @ResponseBody
    public DataInfo queryAdminAll(Admin admin, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Admin> pageInfo = adminService.queryAdminAll(admin, pageNum, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 添加页面的操作
     */
    @GetMapping("/adminAdd")
    public String adminAdd() {
        return "admin/adminAdd";
    }

    /**
     * 添加提交
     */
    @RequestMapping("/addAdminSubmit")
    @ResponseBody
    public DataInfo addAdminSubmit(Admin admin) {
        adminService.addAdminSubmit(admin);
        return DataInfo.ok();
    }

    /**
     * 根据id查询
     */
    @GetMapping("/queryAdminById")
    public String queryAdminById(Integer id, Model model) {
        model.addAttribute("id", id);
        return "admin/updateAdmin";
    }

    /**
     * 修改提交
     */
    @RequestMapping("/updatePwdSubmit")
    @ResponseBody
    public DataInfo updatePwdSubmit(Integer id, String oldPwd, String newPwd) {
        Admin admin = adminService.queryAdminById(id);
        if (!oldPwd.equals(admin.getPassword())) {
            return DataInfo.fail("输入的旧密码错误");
        } else {
            admin.setPassword(newPwd);
            adminService.updateAdminSubmit(admin);
            return DataInfo.ok();
        }
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteAdminByIds")
    @ResponseBody
    public DataInfo deleteAdminByIds(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        adminService.deleteAdminByIds(list);
        return DataInfo.ok();
    }
}