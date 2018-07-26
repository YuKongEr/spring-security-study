package com.yukong.security.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yukong
 * @since 2018-07-26
 */
@Controller
public class UserController {

    @ResponseBody
    @GetMapping({"/", "/index", "/home"})
    public String root(){
        return "root";
    }

    @ResponseBody
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal){
        return principal.getName();
    }

}

