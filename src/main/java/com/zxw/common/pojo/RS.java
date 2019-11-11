package com.zxw.common.pojo;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author zxw
 * @date 2019/11/8 22:12
 */
@NoArgsConstructor
public class RS extends HashMap<String, Object> implements Serializable {

    public static RS ok() {
        RS rs = new RS();
        rs.put("status", "0");
        rs.put("msg", "ok");
        return rs;
    }

    public static RS ok(Object msg) {
        RS rs = new RS();
        rs.put("status", "0");
        rs.put("msg", msg);
        return rs;
    }

    public static RS error(Object msg) {
        RS rs = new RS();
        rs.put("status", "1");
        rs.put("msg", msg);
        return rs;
    }

    public static RS define(String status, Object msg) {
        RS rs = new RS();
        rs.put("status", status);
        rs.put("msg", msg);
        return rs;
    }

    public static RS putMap(String status, HashMap hashMap) {
        RS rs = new RS();
        rs.put("status", status);
        rs.put("msg", hashMap);
        return rs;
    }
}
