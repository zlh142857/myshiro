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

    /*@RequestMapping(value="/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        logger.info("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        logger.info("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                logger.info("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                logger.info("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                logger.info("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
    }*/

    /*@RequestMapping(value="/403")
    public String a403(){
        logger.info("用户进入403.html,报错了");
        return "/403";
    }*/
    /**
     *
     * 功能描述:注册跳转页面
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/10/9 15:35
     */
    /*@RequestMapping(value="/regiset")
    public String regiset(){
        logger.info("用户进入regiset.html");
        return "/regiset";
    }*/

}
