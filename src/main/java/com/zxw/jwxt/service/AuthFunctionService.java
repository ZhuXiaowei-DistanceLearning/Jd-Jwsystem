package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.AuthFunction;
import com.zxw.jwxt.mapper.AuthFunctionMapper;
import com.zxw.jwxt.vo.FunctionQueryParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AuthFunctionService {

    @Autowired
    private AuthFunctionMapper functionMapper;

    public List<AuthFunction> findAll() {
        List<AuthFunction> list = functionMapper.findAll();
        return list;
    }

    public List<AuthFunction> findListByTeacherid(String tid) {
        List<AuthFunction> list = functionMapper.findListByTeacherid(tid);
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    public List<AuthFunction> findListByStudentid(String sid) {
        List<AuthFunction> list = functionMapper.findListByStudentid(sid);
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    public List<AuthFunction> findMenu(String userId) {
        String RadioButtonList1 = (String) SecurityUtils.getSubject().getSession().getAttribute("RadioButtonList1");
        List<AuthFunction> list = null;
        if ("管理员".equals(RadioButtonList1)) {
            list = functionMapper.findMenuByUserid(userId);
        } else if ("教师".equals(RadioButtonList1)) {
            list = functionMapper.findMenuByTeacherid(userId);
        } else if ("学生".equals(RadioButtonList1)) {
            list = functionMapper.findMenuByStudentid(userId);
        }
        return list;
    }

    public RS save(AuthFunction model) {
        functionMapper.insert(model);
        return RS.ok();
    }

    public IPage pageQuery(FunctionQueryParam params) {
        IPage iPage = this.BaseQuery(params);
        return iPage;
    }

    public List<Integer> queryFunctionByRole(String id) {
        List<Integer> list = functionMapper.queryFunctionByRole(id);
        return list;
    }

    public IPage BaseQuery(FunctionQueryParam baseQueryParam) {
        Page page = new Page(baseQueryParam.getOffset(), baseQueryParam.getLimit());
        QueryWrapper queryWrapper = new QueryWrapper();
        if (baseQueryParam.getSort() != null) {
            OrderItem orderItems = new OrderItem();
            orderItems.setColumn(baseQueryParam.getSort());
            orderItems.setAsc(baseQueryParam.isASC());
            page.addOrder(orderItems);
        }
        if (baseQueryParam.getKeyword() != null) {
            Map<String, Object> keyword = baseQueryParam.getKeyword();
            Set<String> strings = keyword.keySet();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                Object o = keyword.get(next);
                queryWrapper.like(next, o);
            }
        }
        if (baseQueryParam.getStatus() != null) {
            queryWrapper.eq("status", baseQueryParam.getStatus());
        }
        IPage iPage = functionMapper.selectPage(page, queryWrapper);
        return iPage;
    }
}
