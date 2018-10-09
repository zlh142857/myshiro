package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/9 10:13
 *@功能:
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/toRegiset")
public class RegisetController {
    @RequestMapping(value="/regisetUser")
    public String regisetUser(){
        return "注册成功";
    }
}
