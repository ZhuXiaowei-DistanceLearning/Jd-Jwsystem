package com.zxw.jwxt.service;

import com.zxw.jwxt.domain.UserNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.dto.NoticeDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxw
 * @since 2020-01-31
 */
public interface IUserNoticeService extends IService<UserNotice> {

    List<NoticeDTO> findNoticeByJW(UserRealm realm);

    List<NoticeDTO> findNoticeByStudent(UserRealm realm);

    List<NoticeDTO> findNoticeByTeacher(UserRealm realm);
}
