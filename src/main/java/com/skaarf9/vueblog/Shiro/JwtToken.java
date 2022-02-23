package com.skaarf9.vueblog.Shiro;/**
 * @author: Administrator
 * @date: 2022/2/23 13:28
 * @description:
 */

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Administrator
 * @date 2022/2/23
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    JwtToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
