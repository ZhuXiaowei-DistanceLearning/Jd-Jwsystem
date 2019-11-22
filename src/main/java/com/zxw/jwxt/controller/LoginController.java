package com.zxw.jwxt.controller;

import com.zxw.common.pojo.RS;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.StringJoiner;

/**
 * @author zxw
 * @date 2019/11/8 21:24
 */
@Controller
public class LoginController extends BaseController {

    /**
     * 登录功能
     *
     * @param username         用户名
     * @param password         密码
     * @param checkcode        验证码
     * @param RadioButtonList1 身份
     * @param request
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public RS login(String username, String password, String checkcode, String RadioButtonList1, HttpServletRequest request) {
        if (checkcode != null && !"".equals(checkcode)) {
            HttpSession session = request.getSession();
            String code = (String) session.getAttribute(new StringJoiner("_").add("code").add(session.getId()).toString());
            if (checkcode.equals(code)) {
                Subject subject = SecurityUtils.getSubject();
                AuthenticationToken token = new UsernamePasswordToken(username, password);
                try {
                    subject.getSession().setAttribute("RadioButtonList1", RadioButtonList1);
                    subject.login(token);
                } catch (AuthenticationException e) {
                    e.printStackTrace();
                    return RS.error("用户名或密码错误");
                }
                return RS.ok();
            }
            return RS.error("验证码错误");
        }
        return RS.error("验证码不能为空");
    }

    /**
     * 用户退出时，销毁Session
     *
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

}
