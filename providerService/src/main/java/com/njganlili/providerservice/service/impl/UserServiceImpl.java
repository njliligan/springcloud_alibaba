package com.njganlili.providerservice.service.impl;

import com.njganlili.commonservice.entity.User;
import com.njganlili.providerservice.dao.UserMapper;
import com.njganlili.interfaces.provider.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author miky
 * @since 2022-02-27
 */
@DubboService
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Value("${dates.b}")
    private int b;

    @GlobalTransactional
    public Integer addUser(User user){
        return this.baseMapper.insert(user);
    }

}
