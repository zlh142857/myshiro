package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 11:16
 *@功能:
 */

import com.hx.model.UserInfo;
import com.hx.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

}
