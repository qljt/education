package com.ctrl.education.controller;

import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.log.factory.LogManager;
import com.ctrl.education.core.log.factory.LogTaskFactory;
import com.ctrl.education.core.support.HttpKit;
import com.ctrl.education.core.utils.IpUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.shiro.ShiroKit;
import com.google.code.kaptcha.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * com.ctrl.education.controller
 *
 * @author liyang
 * @name LoginController
 * @description
 * @date 2018-06-05 上午12:45
 */
@RestController
@RequestMapping("/sys")
public class LoginController extends BaseController {

    @PostMapping("login")
    public Result login(@RequestParam Map<String,Object> param){
        String account = param.get("username").toString().trim().toLowerCase();
        String password = param.get("password").toString().trim().toLowerCase();
        String code = param.get("code").toString().trim();
        if(StringUtils.isEmpty(code)){
            return Result.error("验证码不能为空");
        }
        String kaptcha = (String) HttpKit.getRequest().getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!code.equalsIgnoreCase(kaptcha)){
            return Result.error("验证码不正确");
        }
        Subject subject = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        try {
            subject.login(token);
            SysUser shiroUser = ShiroKit.getUser();
            SysUser sysUser1= ShiroKit.getUser();
            LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), IpUtils.getIpAddr(getHttpServletRequest())));
            return Result.ok(SystemConstant.LOGIN_SUCESS).put("token", ShiroKit.getSession().getId()).put("sysUser",sysUser1);

        } catch (IncorrectCredentialsException e) {
            return Result.error(500,e.getMessage());
        }
    }
    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @GetMapping("/unauth")
    public Result unauth() {
        return Result.error(10002,"您尚未登录");
    }
    @GetMapping("logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(),IpUtils.getIpAddr(getHttpServletRequest())));
        return Result.ok("退出成功");
    }
    @GetMapping("kickout")
    public Result kickout(){
        return Result.error(10001,"您被剔除");
    }
}
