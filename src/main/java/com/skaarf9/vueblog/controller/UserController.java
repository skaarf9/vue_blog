package com.skaarf9.vueblog.controller;


import com.skaarf9.vueblog.common.lang.Result;
import com.skaarf9.vueblog.entity.User;
import com.skaarf9.vueblog.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author skaarf9
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Object index(){
        User user = userService.getById(1L);
        return Result.succ(200, "操作成功", user);
    }

    @PostMapping("/save")
    public Object save(@Validated @RequestBody User user){
        User info = userService.getById(1L);
        return Result.succ(user);
    }
}
