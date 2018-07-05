package com.ctrl.education.service.impl;

import com.ctrl.education.model.SysMenu;
import com.ctrl.education.service.ISysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * com.ctrl.education.service.impl
 *
 * @name SysMenuServiceImplTest
 * @description
 * @date 2018-07-05 16:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuServiceImplTest {
    @Autowired
    private ISysMenuService iSysMenuService;

    @Test
    public void getList() {
    }

    @Test
    public void menuTreeList() {
    }

    @Test
    public void getMenuIdsByRoleId() {
    }

    @Test
    public void menuTreeListByMenuIds() {
    }

    @Test
    public void save() {
        SysMenu sysMenu = new SysMenu();
       /* sysMenu.setCode("enterprise");
        sysMenu.setUrl("#");*/
        sysMenu.setPid("540e16cc7b284d29a3861d3f28d0476d");
        sysMenu.setCode("enterprises");
        sysMenu.setUrl("/enterprises/qzEnterprise.html");
        sysMenu.setName("企业管理");
        iSysMenuService.save(sysMenu);
    }

    @Test
    public void modify() {
    }
}