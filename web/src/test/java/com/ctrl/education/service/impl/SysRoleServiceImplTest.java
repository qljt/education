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
            sysRole.setPids("63696cac480141c0a593cd69390b7bf6,");
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
        String ids = "0049a69635b44f11862d282368606ed3,3095b8492dd74c529c504325a50ee474,540e16cc7b284d29a3861d3f28d0476d,a4d3f74678164fe1918a76091834c76f,cef296d8b0cf454fa5f62a50298553fa,d8f4aa88587149949212d751a7b85d73,f11e7931e47845f79fef8241f95fda31";
        iSysRoleService.setAuthority(roleId,ids);
    }
}