package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.TUser;
import com.zxw.jwxt.service.UserService;
import com.zxw.jwxt.vo.BaseQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/api/user")
public class TUserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/pageQuery")
    public TableReponse pageQuery(BaseQueryParam baseQueryParam) {
        IPage iPage = userService.pageQuery(baseQueryParam);
        TableReponse of = TableReponse.of(iPage);
        return of;
    }

    @PostMapping("/add")
    public RS saveOrUpdate(@RequestBody TUser user) {
        RS rs = userService.saveOrUpdate(user);
        return rs;
    }

    @PutMapping("/edit")
    public RS edit(@RequestBody TUser user){
        RS  rs = userService.edit(user);
        return rs;
    }

    @DeleteMapping("/delete")
    public RS delete(String id) {
        RS rs = userService.lock(id);
        return rs;
    }
}
