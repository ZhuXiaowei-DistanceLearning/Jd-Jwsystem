package com.zxw.jwxt.service.impl;

import com.zxw.jwxt.domain.TUser;
import com.zxw.jwxt.mapper.TUserMapper;
import com.zxw.jwxt.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
