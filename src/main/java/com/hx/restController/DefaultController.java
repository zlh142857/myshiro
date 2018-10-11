package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:26
 *@功能:默认访问页面,先查询用户是否登录,没有登录,返回false,有前端控制跳转至登录页面,如果有登陆,就跳转至首页
 */

import com.hx.model.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class DefaultController {
    /**
     *
     * 功能描述: 默认访问页面,先查询用户是否登录,没有登录,返回false,有前端控制跳转至登录页面,如果有登陆,就跳转至首页
     *
     * @param:
     * @return: 
     * @auther: 张立恒
     * @date: 2018/10/10 9:27
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public boolean unauth(HttpServletRequest request, HttpServletResponse response) {
        boolean status = false;
        String sessionid = SecurityUtils.getSubject().getSession().getId().toString();
        SessionKey key = new WebSessionKey(sessionid,request,response);
        try{
            Session se = SecurityUtils.getSecurityManager().getSession(key);
            Object obj = se.getAttribute(DefaultSubjectContext.AUTHENTICATED_SESSION_KEY);
            if(obj != null){
                status = (Boolean) obj;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Session se = null;
            Object obj = null;
        }
        return status;
    }
    /**
     * 获取用户登录信息
     *
     *
     */
    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo(HttpServletRequest request, HttpServletResponse response){
        String sessionid = SecurityUtils.getSubject().getSession().getId().toString();
        SessionKey key = new WebSessionKey(sessionid,request,response);
        try{
            Session se = SecurityUtils.getSecurityManager().getSession(key);
            Object obj = se.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            SimplePrincipalCollection coll = (SimplePrincipalCollection) obj;
            return (UserInfo)coll.getPrimaryPrincipal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        }
        return null;
    }


}
