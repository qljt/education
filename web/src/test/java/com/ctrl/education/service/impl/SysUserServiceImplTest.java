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
            sysUser.setUsername("admin");
            sysUser.setPassword(SecureUtil.md5("123456"));
           // sysUser.setRoleId("fba8a9fd2a904afdb337236b68d01e32");
            //sysUser.setOfficeId("1f50f25bd16b42c29959dd806537ce67");
            iSysUserService.insert(sysUser);
    }

}