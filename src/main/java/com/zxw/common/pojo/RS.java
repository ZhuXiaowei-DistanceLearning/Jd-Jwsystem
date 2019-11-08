package com.zxw.common.pojo;

import com.baomidou.mybatisplus.extension.api.R;

import java.util.HashMap;

/**
 * @author zxw
 * @date 2019/11/8 22:12
 */
public class RS extends HashMap {
    private final Object status;
    private final Object msg;

    public static RS ok() {
        RS rs = new RS("0", "ok");
        return rs;
    }

    public static RS error(Object msg) {
        RS rs = new RS("1", msg);
        return rs;
    }

    public static RS define(Object status, Object msg) {
        RS rs = new RS("1", msg);
        return rs;
    }

    public RS(Object status, Object msg) {
        this.msg = msg;
        this.status = status;
    }
}
