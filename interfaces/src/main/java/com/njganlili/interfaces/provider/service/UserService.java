package com.njganlili.interfaces.provider.service;

import com.njganlili.commonservice.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author miky
 * @since 2022-02-27
 */
public interface UserService extends IService<User> {

    public Integer addUser(User user);

}
