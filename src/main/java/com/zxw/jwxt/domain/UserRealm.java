package com.zxw.jwxt.domain;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zxw
 * @date 2019/11/7 22:01
 */
@Data
public class UserRealm implements Realm {
    private String userId;
    private String name;
    private String role;
    private String salt;
    /**
     * 用户所有角色值，用于shiro做角色权限的判断
     */
    private Set<String> roles = new HashSet<>();
    /**
     * 用户所有权限值，用于shiro做资源权限的判断
     */
    private Set<String> perms = new HashSet<>();

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        // 令牌支持
        Object principal = authenticationToken.getPrincipal();
        System.out.println("-----principal");
        System.out.println(principal.toString());
        Object credentials = authenticationToken.getCredentials();
        System.out.println("-----credentials");
        System.out.println(credentials.toString());
        return true;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 身份验证
        // 授权获取
        Object principal = authenticationToken.getPrincipal();
        System.out.println("-----principal");
        System.out.println(principal.toString());
        Object credentials = authenticationToken.getCredentials();
        System.out.println("-----credentials");
        System.out.println(credentials.toString());
        return null;
    }
}
