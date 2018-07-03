package com.ctrl.education.service.impl;

import com.ctrl.education.model.SysRole;
import com.ctrl.education.service.ISysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * com.ctrl.education.service.impl
 *
 * @name SysRoleServiceImplTest
 * @description
 * @date 2018-07-02 15:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleServiceImplTest {
    @Autowired
    private ISysRoleService iSysRoleService;
    @Test
    public void add() {
        SysRole sysRole = new SysRole();
        sysRole.setName("超级管理员");
        sysRole.setPid("0");
        sysRole.setOfficeId("1dcddd66c34a4094912466392542f8f7");
        iSysRoleService.insert(sysRole);

    }
}