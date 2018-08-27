package com.ctrl.education.service.impl;

import com.ctrl.education.core.utils.AlohaDateUtils;
import com.ctrl.education.model.QzIntegralRule;
import com.ctrl.education.service.IQzIntegralRuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * com.ctrl.education.service.impl
 *
 * @author ctrl
 * @name QzIntegralRuleServiceImplTest
 * @description
 * @date 2018-08-13 下午4:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QzIntegralRuleServiceImplTest {
    @Autowired
    private IQzIntegralRuleService iQzIntegralRuleService;

    @Test
    public void saveTest(){
        for (int i = 0; i < 8; i++) {
            QzIntegralRule qzIntegralRule = new QzIntegralRule();
            qzIntegralRule.setCreatetime(AlohaDateUtils.getDay());
            iQzIntegralRuleService.insert(qzIntegralRule);
        }
    }

}