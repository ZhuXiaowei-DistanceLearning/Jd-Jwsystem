package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.Menu;
import com.zxw.jwxt.mapper.MenuMapper;
import com.zxw.jwxt.service.BaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxw.jwxt.vo.BaseQueryParam;
import com.zxw.jwxt.vo.QueryFunctionVO;
import com.zxw.jwxt.vo.QueryRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zxw
 * @since 2019-12-24
 */
@Service
public class MenuService extends BaseService {

    @Autowired
    private MenuMapper menuMapper;

    public IPage pageQuery(QueryFunctionVO functionQueryParam) {
        IPage iPage = this.BaseQuery(functionQueryParam);
        return iPage;
    }

    public IPage BaseQuery(QueryFunctionVO functionQueryParam) {
        Page page = getPage(functionQueryParam);
        QueryWrapper queryWrapper = getWrapper(functionQueryParam, null);
        IPage iPage = menuMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    public RS add(Menu menu) {
        int insert = menuMapper.insert(menu);
        return insert == 1 ? RS.ok() : RS.error("添加权限失败");
    }

    public List<Menu> listajax(BaseQueryParam baseQueryParam) {
        return menuMapper.selectList(this.getWrapper(baseQueryParam, null));
    }

    public RS delete(Long menuId) {
        QueryWrapper queryWrapper = this.queryOne("id", menuId);
        queryWrapper.or();
        queryWrapper.eq("pid",menuId);
        List list = menuMapper.selectList(queryWrapper);
        return RS.ok();
    }

}
