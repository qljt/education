package com.ctrl.education.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.service.ISysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * com.ctrl.education.service.impl
 *
 * @name SysUserServiceImplTest
 * @description
 * @date 2018-07-02 16:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceImplTest {
    @Autowired
    private ISysUserService iSysUserService;

    @Test
    public void add() {
        SysUser sysUser = new SysUser();
            sysUser.setUsername("admin" + 5);
            sysUser.setPassword(SecureUtil.md5("123456"));
            sysUser.setRoleId("63696cac480141c0a593cd69390b7bf6");
            sysUser.setOfficeId("1dcddd66c34a4094912466392542f8f7");
            iSysUserService.insert(sysUser);
    }

}