package com.skaarf9.vueblog.common.dto;/**
 * @author: Administrator
 * @date: 2022/2/23 21:28
 * @description:
 */

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Administrator
 * @date 2022/2/23
 */
@Data
public class LoginDto implements Serializable {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
