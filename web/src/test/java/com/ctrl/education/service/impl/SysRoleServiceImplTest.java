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
        for (int i = 0; i <100 ; i++) {
            SysRole sysRole = new SysRole();
            sysRole.setName("管理员"+i);
            sysRole.setPid("63696cac480141c0a593cd69390b7bf6");
            sysRole.setPids("08c7c2ad77344f3da66145a0d8efdc74,");
            sysRole.setOfficeId("1dcddd66c34a4094912466392542f8f7");
            iSysRoleService.add(sysRole);
        }

    }
    @Test
    public void getList(){
        Map<String,Object> map = new HashMap<>();
        map.put("page","0");
        map.put("limit","15");
        Result result = iSysRoleService.getList(map);
        System.out.println(result);
    }
    @Test
    public void setAuthority(){
        SysRole sysRole = new SysRole();
        sysRole.setOfficeId("1dcddd66c34a4094912466392542f8f7");
        String roleId = "63696cac480141c0a593cd69390b7bf6";
        String ids = "08c7c2ad77344f3da66145a0d8efdc74";
        iSysRoleService.setAuthority(roleId,ids);
    }
}