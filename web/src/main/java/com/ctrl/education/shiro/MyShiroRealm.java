package com.ctrl.education.shiro;

import cn.hutool.crypto.SecureUtil;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.service.ISysUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * com.ctrl.education.shiro
 *
 * @author liyang
 * @name MyShiroRealm
 * @description
 * @date 2018-06-05 上午12:13
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //用户登录次数计数  redisKey 前缀
    private String SHIRO_LOGIN_COUNT = "shiro_login_count_";

    //用户登录是否被锁定    一小时 redisKey 前缀
    private String SHIRO_IS_LOCK = "shiro_is_lock_";

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        //访问一次，计数一次
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.increment(SHIRO_LOGIN_COUNT + name, 1);
        //计数大于5时，设置用户被锁定一小时
        if (Integer.parseInt(opsForValue.get(SHIRO_LOGIN_COUNT + name)) >= 5) {
            opsForValue.set(SHIRO_IS_LOCK + name, "LOCK");
            stringRedisTemplate.expire(SHIRO_IS_LOCK + name, 1, TimeUnit.HOURS);
        }
        if ("LOCK".equals(opsForValue.get(SHIRO_IS_LOCK + name))) {
            throw new DisabledAccountException("由于密码输入错误次数大于5次，帐号已经禁止登录！");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("account", name);
        map.put("password", SecureUtil.md5(password));
        SysUser user = null;
        // 从数据库获取对应用户名密码的用户
        List<SysUser> userList = iSysUserService.selectByMap(map);
        if (userList.size() != 0) {
            user = userList.get(0);
        }
        if (null == user) {
            throw new AccountException("帐号或密码不正确！");
        } else if ("0".equals(user.getStatus())) {
            /**
             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
             */
            throw new DisabledAccountException("此帐号已经设置为禁止登录！");
        } else {
            //登录成功
            //更新登录时间 last login time
            user.setLastLoginTime(new Date());
            iSysUserService.updateById(user);
            //清空登录计数
            opsForValue.set(SHIRO_LOGIN_COUNT + name, "0");
        }
        Logger.getLogger(getClass()).info("身份认证成功，登录用户：" + name);
        return new SimpleAuthenticationInfo(user, password, getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        try {
           /* List<SysRole> roles = sysRoleService.selectRoleByUser(sysUser);
            for (SysRole role : roles) {
                authorizationInfo.addRole(role.getName());
            }
            List<SysPermission> sysPermissions = sysPermissionService.selectPermByUser(sysUser);
            for (SysPermission perm : sysPermissions) {
                authorizationInfo.addStringPermission(perm.getName());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

}
