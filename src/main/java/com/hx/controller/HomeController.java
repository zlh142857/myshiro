package com.hx.controller;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 8:53
 *@功能:跳转页面
 */

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    //"/"或"/index",跳转至index.html
    @RequestMapping({"/","/index"})
    public String index(){
        logger.info("用户进入index.html");
        return"/index";
    }

    @RequestMapping(value="/login")
    public String login(){
        logger.info("用户进入login.html");
        return"login";
    }
    @RequestMapping(value="/403")
    public String a403(){
        logger.info("用户进入403.html,报错了");
        return"403";
    }
}
