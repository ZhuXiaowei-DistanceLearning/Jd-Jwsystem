package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.TUser;
import com.zxw.jwxt.service.UserService;
import com.zxw.jwxt.vo.BaseQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/user")
public class TUserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/pageQuery")
    public TableReponse pageQuery(BaseQueryParam baseQueryParam) {
        IPage iPage = userService.pageQuery(baseQueryParam);
        TableReponse of = TableReponse.of(iPage);
        return of;
    }

    @PostMapping("/saveOrUpdate")
    public RS saveOrUpdate(TUser user) {
        RS rs = userService.saveOrUpdate(user);
        return rs;
    }

    @GetMapping("/delete")
    public RS delete(String id) {
        RS rs = userService.lock(id);
        return rs;
    }
}
