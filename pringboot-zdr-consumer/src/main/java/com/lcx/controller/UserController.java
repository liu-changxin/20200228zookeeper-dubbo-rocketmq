package com.lcx.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcx.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private IUserService iUserService;

    @RequestMapping("/user")
    @ResponseBody
    public String selectUser(String name){
        System.out.println("我是服务实体类"+iUserService);
        System.out.println("我是传值"+name);
        return iUserService.sayHello(name);
    }
}
