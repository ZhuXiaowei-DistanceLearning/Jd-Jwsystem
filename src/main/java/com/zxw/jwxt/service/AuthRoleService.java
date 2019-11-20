package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.AuthRole;
import com.zxw.jwxt.mapper.AuthRoleMapper;
import com.zxw.jwxt.vo.RoleQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//@Transactional(rollbackFor = Exception.class)
public class AuthRoleService extends BaseService {

    @Autowired
    private AuthRoleMapper roleMapper;

    public IPage pageQuery(RoleQueryParam roleQueryParam) {
        IPage iPage = this.BaseQuery(roleQueryParam);
        return iPage;
    }

    public RS save(AuthRole role, String ids) {
        roleMapper.insert(role);
        String[] id = ids.split(",");
        for (String functionId : id) {
            roleMapper.RoleinsertFunction(role.getId(), functionId);
        }
        return RS.ok();
    }

    public RS update(String ids, String roleId) {
        List<String> list = roleMapper.queryFunctionByRole(roleId);
        for (int i = 0; i < list.size(); i++) {
            roleMapper.deleteRoleFunction(list.get(i));
        }
        String[] id = ids.split(",");
        for (String functionId : id) {
            roleMapper.insertFunction(roleId, functionId);
        }
        return RS.ok();
    }

    public RS deleteRole(String roleId) {
        roleMapper.deleteFunction(roleId);
        roleMapper.deleteRole(roleId);
        return RS.ok();
    }

    public IPage BaseQuery(RoleQueryParam baseQueryParam) {
        Page page = getPage(baseQueryParam);
        QueryWrapper queryWrapper = getWrapper(page, baseQueryParam);
        IPage iPage = roleMapper.selectPage(page, queryWrapper);
        return iPage;
    }
}
