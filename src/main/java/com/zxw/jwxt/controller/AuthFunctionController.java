package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.MenuNode;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.AuthFunction;
import com.zxw.jwxt.service.AuthFunctionService;
import com.zxw.jwxt.vo.FunctionQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/function")
public class AuthFunctionController extends BaseController {
    @Autowired
    private AuthFunctionService functionSerivce;

    @GetMapping("/pageQuery")
    public TableReponse pageQuery(FunctionQueryParam functionQueryParam) throws IOException {
        IPage pageUtils = functionSerivce.pageQuery(functionQueryParam);
        TableReponse reponse = TableReponse.of(pageUtils);
        return reponse;
    }

    @GetMapping("/listajax")
    public List<AuthFunction> listajax() throws IOException {
        List<AuthFunction> list = functionSerivce.findAll();
        return list;
    }

    @GetMapping("/queryFunctionByRole")
    public List<Integer> queryFunctionByRole(String id) throws IOException {
        List<Integer> list = functionSerivce.queryFunctionByRole(id);
        return list;
    }

    @PostMapping("/add")
    public RS add(AuthFunction function) {
        RS rs = functionSerivce.save(function);
        return rs;
    }

    @PostMapping("/update")
    public void update(String ids, String roleId) {
        System.out.println(ids);
        System.out.println(roleId.toString());
    }

    /**
     * @return
     * @throws IOException
     */
    @GetMapping("/menu")
    public List<MenuNode> findMenu() throws IOException {
        List<MenuNode> menuNodes = new ArrayList<>();
        List<AuthFunction> list = functionSerivce.findMenu(getUserId());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPid() == null) {
                MenuNode menuNode = new MenuNode(list.get(i), new ArrayList<>());
                menuNodes.add(menuNode);
            }
        }
        List<MenuNode> nodes = this.generateMenu(menuNodes, list);
        return nodes;
    }

    private List<MenuNode> generateMenu(List<MenuNode> menuNodes, List<AuthFunction> list) {
        List<MenuNode> collect = menuNodes.stream().map((e) -> {
            for (int i = 0; i < list.size(); i++) {
                if (!"".equals(list.get(i).getPid()) && list.get(i).getPid() != null) {
                    if (list.get(i).getPid().equals(e.getAuthFunction().getId())) {
                        MenuNode menuNode = new MenuNode(list.get(i), new ArrayList<>());
                        e.getList().add(menuNode);
                    }
                    if (e.getList().size() != 0) {
                        generateMenu(e.getList(), list);
                    }
                }
            }
            return e;
        }).collect(Collectors.toList());
        return collect;
    }

}
