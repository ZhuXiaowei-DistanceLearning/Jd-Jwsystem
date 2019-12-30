package com.zxw.jwxt.controller;


import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.Menu;
import com.zxw.jwxt.service.MenuService;
import com.zxw.jwxt.vo.BaseQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-12-24
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/add")
    public RS add(@RequestBody Menu menu) {
        return menuService.add(menu);
    }

    @PutMapping("/edit")
    public RS edit(@RequestBody Menu menu) {
        return menuService.edit(menu);
    }

    @DeleteMapping("/delete")
    public RS delete(Long menuId) {
        return menuService.delete(menuId);
    }

    @GetMapping("/listajax")
    public List<Menu> listajax(BaseQueryParam baseQueryParam) {
        return menuService.listajax(baseQueryParam);
    }
}
