package com.skaarf9.vueblog.service.impl;

import com.skaarf9.vueblog.entity.User;
import com.skaarf9.vueblog.mapper.UserMapper;
import com.skaarf9.vueblog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author skaarf9
 * @since 2022-02-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
