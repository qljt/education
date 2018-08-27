package com.ctrl.education.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ctrl.education.core.utils.AlohaDateUtils;
import com.ctrl.education.dao.QzForumGroupMapper;
import com.ctrl.education.dao.QzUsersMapper;
import com.ctrl.education.model.QzForumGroup;
import com.ctrl.education.model.QzForumGroupTopic;
import com.ctrl.education.model.QzForumGroupUsers;
import com.ctrl.education.model.QzUsers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * com.ctrl.education.service
 *
 * @author ctrl
 * @name IQzForumGroupUsersServiceTest
 * @description
 * @date 2018-08-19 下午2:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IQzForumGroupUsersServiceTest {
    @Autowired
    private IQzForumGroupUsersService iQzForumGroupUsersService;
    @Autowired
    private QzUsersMapper qzUsersMapper;
    @Autowired
    private QzForumGroupMapper qzForumGroupMapper;

    @Test
    public void save() {
       List<QzUsers> list =  qzUsersMapper.selectList(
                new EntityWrapper<QzUsers>().ne("state",0)
        );
        List<QzForumGroup> qzForumGroups = qzForumGroupMapper.selectList(
                new EntityWrapper<QzForumGroup>()
        );

        for(QzForumGroup qzForumGroup:qzForumGroups){
            for(QzUsers qzUsers1:list){
                QzForumGroupUsers qzForumGroupUsers = new QzForumGroupUsers();
                qzForumGroupUsers.setGroupId(qzForumGroup.getId());
                qzForumGroupUsers.setUsersId(qzUsers1.getId());
                qzForumGroupUsers.setState(1);
                qzForumGroupUsers.setCreatetime(AlohaDateUtils.getDay());
                iQzForumGroupUsersService.insert(qzForumGroupUsers);
            }
        }

        /*for (QzUsers qzUsers:list.subList(0,5)){
           QzForumGroupUsers qzForumGroupUsers = new QzForumGroupUsers();
           qzForumGroupUsers.setGroupId("2536c358b9074bceac3aaad7d07384b3");
           qzForumGroupUsers.setUsersId(qzUsers.getId());
           qzForumGroupUsers.setState(1);
           qzForumGroupUsers.setCreatetime(AlohaDateUtils.getDay());
           iQzForumGroupUsersService.insert(qzForumGroupUsers);
       }*/

    }


}