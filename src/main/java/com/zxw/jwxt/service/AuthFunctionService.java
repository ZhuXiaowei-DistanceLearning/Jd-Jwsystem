package com.zxw.jwxt.service;

import com.zxw.jwxt.domain.AuthFunction;
import com.baomidou.mybatisplus.extension.service.IService;
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

    public List<AuthFunction> findAll() {
        return null;
    }

    public List<AuthFunction> findListByTeacherid(String tid) {
        return null;
    }

    public List<AuthFunction> findListByStudentid(String sid) {
        return null;
    }
}
