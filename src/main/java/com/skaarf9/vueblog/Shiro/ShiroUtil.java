package com.skaarf9.vueblog.Shiro;/**
 * @author: Administrator
 * @date: 2022/2/23 22:39
 * @description:
 */

import org.apache.shiro.SecurityUtils;

/**
 * @author Administrator
 * @date 2022/2/23
 */
public class ShiroUtil {
    public static AccountProfile getProfile(){
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
