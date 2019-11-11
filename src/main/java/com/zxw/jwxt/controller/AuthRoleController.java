package com.zxw.jwxt.controller;


import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.AuthRole;
import com.zxw.jwxt.service.AuthRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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

    @RequestMapping("/add")
    public String add(String ids, AuthRole role) {
//        roleSerivce.save(role, ids);
        return "redirect:/page/admin/role.action";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(String ids, String roleId) {
//        roleSerivce.update(ids,roleId);
        return "true";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String roleId) {
//        roleSerivce.deleteRole(roleId);
        return "true";
    }

    @RequestMapping("/pageQuery")
    @ResponseBody
    public TableReponse pageQuery(Integer page, Integer rows) throws IOException {
//        EasyUIDataGridResult result = roleSerivce.pageQuery(page, rows);
//        return result;
        return null;
    }

    @RequestMapping("/listajax")
    @ResponseBody
    public List<AuthRole> listajax() throws IOException {
//        List<AuthRole> list = roleSerivce.findAll();
//        return list;
        return null;
    }

    @RequestMapping("/page")
    public String page() {
        return "/admin/role";
    }

    @RequestMapping("/pageAdd")
    public String pageAdd() {
        return "/admin/role_add";
    }
}
