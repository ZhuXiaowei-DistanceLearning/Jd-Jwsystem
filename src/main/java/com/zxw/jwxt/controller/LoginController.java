package com.zxw.jwxt.controller;

import com.zxw.common.pojo.RS;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.protocol.http.AuthenticationInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.StringJoiner;

/**
 * @author zxw
 * @date 2019/11/8 21:24
 */
@Controller
public class LoginController extends BaseController {

    @PostMapping("/login")
    @ResponseBody
    public RS login(String username, String password, String checkcode, String RadioButtonList1, HttpServletRequest request) {
        if (checkcode != null && !"".equals(checkcode)) {
            HttpSession session = request.getSession();
            String code = (String) session.getAttribute(new StringJoiner("_").add("code").add(session.getId()).toString());
            if (checkcode.equals(code)) {
                Subject subject = SecurityUtils.getSubject();
                AuthenticationToken token = new UsernamePasswordToken(username, password);
                subject.login(token);
                return RS.ok();
            }
            return RS.error("验证码错误");
        }
        return RS.error("验证码不能为空");
    }
}
