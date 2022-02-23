package com.skaarf9.vueblog.Shiro;/**
 * @author: Administrator
 * @date: 2022/2/22 18:07
 * @description:
 */

import cn.hutool.core.bean.BeanUtil;
import com.skaarf9.vueblog.entity.User;
import com.skaarf9.vueblog.service.IUserService;
import com.skaarf9.vueblog.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2022/2/22
 */
@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    IUserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 用于授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 用于认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwt = (JwtToken) authenticationToken;
        String userId = jwtUtils.getClaimsByToken((String) jwt.getPrincipal()).getSubject();
        User user = userService.getById(Long.valueOf(userId));
        if(user == null){
            throw new UnknownAccountException("账户不存在");
        }
        if(user.getStatus() == -1){
            throw new LockedAccountException("账户已被锁定");
        }
        AccountProfile accountProfile = new AccountProfile();
        BeanUtil.copyProperties(user, accountProfile);

        System.out.println("-----------------");
        return new SimpleAuthenticationInfo(accountProfile, jwt.getCredentials(), getName());
    }
}
