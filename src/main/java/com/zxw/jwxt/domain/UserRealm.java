package com.zxw.jwxt.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zxw
 * @date 2019/11/7 22:01
 */
@Data
public class UserRealm {
    private String id;
    private String name;
    private String qx;
    private String salt;
    /**
     *
     * 用户所有角色值，用于shiro做角色权限的判断
     */
    private Set<String> roles = new HashSet<>();
    /**
     *
     * 用户所有权限值，用于shiro做资源权限的判断
     */
    private Set<String> perms = new HashSet<>();
}
