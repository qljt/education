package com.ctrl.education.service;

import com.ctrl.education.core.utils.AlohaDateUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzForumGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * com.ctrl.education.service
 *
 * @author ctrl
 * @name IQzForumGroupServiceTest
 * @description
 * @date 2018-08-18 下午5:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IQzForumGroupServiceTest {
    @Autowired
    private IQzForumGroupService iQzForumGroupService;

    @Test
    public void getInfo() {
    }

    @Test
    public void getList() {
        Map<String,Object> param = new HashMap<>();
        param.put("nmame","");
        Result result = iQzForumGroupService.getList(param);
        System.out.println(result);
    }

    @Test
    public void save() {
        for (int i = 1; i < 23; i++) {
            QzForumGroup qzForumGroup = new QzForumGroup();
            qzForumGroup.setCreatetime(AlohaDateUtils.getDay());
            qzForumGroup.setName("test"+i);
            qzForumGroup.setSysUserId("36dd669d955011e8bf5000163e00053c");
            iQzForumGroupService.save(qzForumGroup);
        }
    }

    @Test
    public void modify() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void disable() {
    }
}