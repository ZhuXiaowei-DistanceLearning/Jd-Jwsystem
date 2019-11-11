package com.zxw.jwxt.service;

import com.zxw.jwxt.domain.TUser;
import com.zxw.jwxt.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UserService {

    @Autowired
    private TUserMapper userMapper;

    /**
     * 根据用户名(id)查找用户
     * @param username
     * @return
     */
    public TUser findByUsername(String username) {
        TUser user = userMapper.selectById(username);
        return user;
    }
}
