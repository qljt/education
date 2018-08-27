package com.ctrl.education.service.impl;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysRole;
import com.ctrl.education.service.ISysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

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
        iSysRoleService.add(sysRole);

    }

    @Test
    public void getList() {
        Map<String, Object> map = new HashMap<>();
        map.put("page", "0");
        map.put("limit", "15");
        Result result = iSysRoleService.getList(map);
        System.out.println(result);
    }

    @Test
    public void setAuthority() {
        SysRole sysRole = new SysRole();
        String roleId = "fba8a9fd2a904afdb337236b68d01e32";
        String ids = "0049a69635b44f11862d282368606ed3,08c7c2ad77344f3da66145a0d8efdc74,29929643719e4f5089b497166e65527d,3095b8492dd74c529c504325a50ee474,8acd4be99ead43fead0dec9c6c952ca6,a4d3f74678164fe1918a76091834c76f,b47a1eaddfb144d7ad54519745712e88,d8f4aa88587149949212d751a7b85d73,f11e7931e47845f79fef8241f95fda31";
        iSysRoleService.setAuthority(roleId, ids);
    }
}