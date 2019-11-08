package com.zxw.jwxt.service;

import com.zxw.jwxt.domain.TStudent;
import com.baomidou.mybatisplus.extension.service.IService;
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
public class StudentService {

    public TStudent findByUsername(String username) {
        return null;
    }
}
