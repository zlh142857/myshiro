package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 11:16
 *@功能:
 */

import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理的注解
    @ResponseBody
    public String userInfo(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "userInfo");
        return jsonObject.toString();
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理的注解
    public String userInfoAdd(){
        return "userInfoAdd";
    }
    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }



}
