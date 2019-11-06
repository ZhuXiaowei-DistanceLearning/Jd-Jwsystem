package com.zxw.jwxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zxw
 * @date 2019/11/6 20:23
 */
@RequestMapping("/")
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "web/login";
    }
}
