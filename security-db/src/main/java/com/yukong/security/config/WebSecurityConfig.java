package com.yukong.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    /**
     * 匹配 "/" 路径 不要权限就可以访问
     * 匹配 "/user" 及其以下所有路径，都需要 user 权限
     * 登录地址为login，登录成功默认url  /user
     * 退出登录地址为 /logout 退出成功跳转地址为 /login
     * 默认启用CSRF
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/").permitAll()
               .antMatchers("/user/**").hasRole("USER")
               .and()
               .formLogin().defaultSuccessUrl("/user")
               .and()
               .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

    /**
     * 添加 UserDetailsService 实现自定义登录校验
     * @param builder
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder  builder) throws Exception {
        builder.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
        super.configure(builder);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
