package com.ctrl.education.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.model.QzEnterprise;
import com.ctrl.education.service.IQzEnterpriseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * com.ctrl.education.service.impl
 *
 * @author ly
 * @name QzEnterpriseServiceImplTest
 * @description
 * @date 2018-06-04 18:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QzEnterpriseServiceImplTest {
    @Autowired
    private IQzEnterpriseService iQzEnterpriseService;
    @Test
    public void getListTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("enterprise_name","");
        Result result = iQzEnterpriseService.getList(map);
        System.out.println(result);
    }
    @Test
    public  void  saveTest(){
        QzEnterprise qzEnterprise = new QzEnterprise();
      /*  String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        qzEnterprise.setId(uuid);
        qzEnterprise.setCreatetime(DateUtil.now());*/
        for (int i = 0; i <100 ; i++) {
            qzEnterprise.setEnterpriseName(String.valueOf(ToolUtils.getRandomChar()));
            qzEnterprise.setSysCode(RandomUtil.randomString(4));
            iQzEnterpriseService.save(qzEnterprise);
        }

    }

}