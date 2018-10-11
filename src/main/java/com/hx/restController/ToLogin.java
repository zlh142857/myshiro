package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:36
 *@功能:
 */

import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/toLogin")
public class ToLogin {
    /**
     * 登录方法
     * @param
     * @return
     * String username,String password,boolean rememberMe
     */
    @RequestMapping(value = "/ajaxLogin")
    @ResponseBody
    public String ajaxLogin(HttpServletRequest request) {
        String data = request.getParameter("data");
        JSONObject jsonObject = new JSONObject();
        if(data==null){
            jsonObject.put("msg", "传值失败");
            return jsonObject.toString();
        }
        JSONObject json= JSONObject.fromObject(data);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                json.get("username").toString(),
                json.get("password").toString(),
                json.get("rememberMe").toString()
        );
        /*JSONObject jsonObject = new JSONObject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
        Subject subject = SecurityUtils.getSubject();*/
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
    /**
     *
     * 功能描述: 注销
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2018/10/9 15:36
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout(HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "已注销");
        return jsonObject.toString();
    }
}
