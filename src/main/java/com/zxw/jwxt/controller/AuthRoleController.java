package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.AuthRole;
import com.zxw.jwxt.service.AuthRoleService;
import com.zxw.jwxt.vo.QueryRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/role")
public class AuthRoleController extends BaseController {

    @Autowired
    private AuthRoleService roleService;

    @GetMapping("/add")
    public RS add(String ids, AuthRole role) {
        RS rs = roleService.save(role, ids);
        return rs;
    }

    @PostMapping("/update")
    public RS update(String ids, String roleId) {
        RS rs = roleService.update(ids, roleId);
        return rs;
    }

    @GetMapping("/delete")
    public RS delete(String roleId) {
        RS rs = roleService.deleteRole(roleId);
        return rs;
    }

    @GetMapping("/pageQuery")
    public TableReponse pageQuery(QueryRoleVO roleQueryParam) {
        IPage result = roleService.pageQuery(roleQueryParam);
        TableReponse response = TableReponse.of(result);
        return response;
    }

    @GetMapping("/listajax")
    public List<AuthRole> listajax(QueryRoleVO roleQueryParam)  {
//        List<AuthRole> list = roleSerivce.findAll();
//        return list;
        List<AuthRole> list = roleService.listajax(roleQueryParam);
        return list;
    }
}
