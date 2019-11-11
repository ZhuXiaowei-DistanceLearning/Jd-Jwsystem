package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.PageUtils;
import com.zxw.jwxt.domain.AuthFunction;
import com.zxw.jwxt.mapper.AuthFunctionMapper;
import com.zxw.jwxt.vo.FunctionQueryParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public void save(AuthFunction model) {
        functionMapper.insert(model);
    }

    public PageUtils pageQuery(FunctionQueryParam params) {
        IPage ipage = new Page(params.getLimit(), params.getOffset());
        Wrapper wrapper = new QueryWrapper<>();
        IPage page = functionMapper.selectPage(ipage, wrapper);
        PageUtils pageUtils = (PageUtils) page;
        return pageUtils;
    }

    public List<Integer> queryFunctionByRole(String id) {
        List<Integer> list = functionMapper.queryFunctionByRole(id);
        return list;
    }
}
