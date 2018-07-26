package com.yukong.security.service;

import com.baomidou.mybatisplus.service.IService;
import com.yukong.security.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yukong
 * @since 2018-07-26
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名查询用户
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    public User loadUserByUsername(String s) throws UsernameNotFoundException ;

    /**
     * 注册用户
     * @param user
     */
    public void register(User user);
    }
