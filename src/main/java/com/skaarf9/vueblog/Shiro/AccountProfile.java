package com.skaarf9.vueblog.Shiro;/**
 * @author: Administrator
 * @date: 2022/2/23 14:59
 * @description:
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 2022/2/23
 */
@Data
public class AccountProfile implements Serializable {
    private Long id;

    private String username;

    private String avatar;

    private String email;
}
