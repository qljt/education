package com.ctrl.education.service.impl;

import com.ctrl.education.model.SysOffice;
import com.ctrl.education.service.ISysOfficeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * com.ctrl.education.service.impl
 *
 * @name SysOfficeServiceImplTest
 * @description
 * @date 2018-07-02 15:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysOfficeServiceImplTest {
    @Autowired
    private ISysOfficeService iSysOfficeService;

    @Test
    public void save() {
        SysOffice sysOffice = new SysOffice();
        sysOffice.setCode("AAAA");
        sysOffice.setName("总公司");
        sysOffice.setPid("0");
        sysOffice.setPids("0");
        sysOffice.setSysCode("0xib");
        iSysOfficeService.save(sysOffice);
    }
}