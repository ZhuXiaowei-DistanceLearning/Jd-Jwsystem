package com.zxw.jwxt.service.impl;

import com.zxw.jwxt.domain.TUser;
import com.zxw.jwxt.domain.UserNotice;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.dto.NoticeDTO;
import com.zxw.jwxt.mapper.UserNoticeMapper;
import com.zxw.jwxt.service.IUserNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zxw
 * @since 2020-01-31
 */
@Service
public class UserNoticeServiceImpl extends ServiceImpl<UserNoticeMapper, UserNotice> implements IUserNoticeService {
    @Autowired
    private UserNoticeMapper userNoticeMapper;

    @Override
    public List<NoticeDTO> findNoticeByJW(UserRealm realm) {
        TUser user = (TUser) realm;
        List<NoticeDTO> list = userNoticeMapper.findNoticeByJW(user.getCollegeId());
        return list;
    }

    @Override
    public List<NoticeDTO> findNoticeByStudent(UserRealm realm) {
        TUser user = (TUser) realm;
        List<NoticeDTO> list = userNoticeMapper.findNoticeByStudent(user.getId());
        return list;
    }

    @Override
    public List<NoticeDTO> findNoticeByTeacher(UserRealm realm) {
        TUser user = (TUser) realm;
        List<NoticeDTO> list = userNoticeMapper.findNoticeByTeacher(user.getId());
        return list;
    }
}
