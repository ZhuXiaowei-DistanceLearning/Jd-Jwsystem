package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.Menu;
import com.zxw.jwxt.mapper.MenuMapper;
import com.zxw.jwxt.service.BaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxw.jwxt.vo.QueryFunctionVO;
import com.zxw.jwxt.vo.QueryRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
