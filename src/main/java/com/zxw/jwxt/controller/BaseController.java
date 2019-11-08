package com.zxw.jwxt.controller;

import com.zxw.jwxt.domain.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author zxw
 * @date 2019/11/7 21:12
 */
public class BaseController {
    public String getUserId() {
        Subject subject = SecurityUtils.getSubject();
        UserRealm user = (UserRealm) subject.getPrincipal();
        return user.getUserId();
    }

    public String getUserQx() {
        String qx = (String) SecurityUtils.getSubject().getSession().getAttribute("qx");
        return qx;
    }
}
