package org.tiamat.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BaseController {
    /**
     * 首页
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 欢迎页面跳转
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/updatePassword")
    public String updatePwd() {
        return "pwdUpdate/updatePwd";
    }
}
