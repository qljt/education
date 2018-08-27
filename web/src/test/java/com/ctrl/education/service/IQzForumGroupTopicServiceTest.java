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

import static org.junit.Assert.*;

/**
 * com.ctrl.education.service
 *
 * @author ctrl
 * @name IQzForumGroupTopicServiceTest
 * @description
 * @date 2018-08-19 下午2:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IQzForumGroupTopicServiceTest {

    @Autowired
    private IQzForumGroupTopicService iQzForumGroupTopicService;

    @Autowired
    private QzForumGroupMapper qzForumGroupMapper;

    @Autowired
    private QzUsersMapper qzUsersMapper;

    @Test
    public void save() {
        List<QzUsers> qzUsers =  qzUsersMapper.selectList(
                new EntityWrapper<QzUsers>().ne("state",0)
        );
        List<QzForumGroup> qzForumGroups = qzForumGroupMapper.selectList(
                new EntityWrapper<QzForumGroup>()
        );

        for(QzForumGroup qzForumGroup:qzForumGroups){
            for(QzUsers qzUsers1:qzUsers){
                QzForumGroupTopic qzForumGroupTopic = new QzForumGroupTopic();
                qzForumGroupTopic.setGroupId(qzForumGroup.getId());
                qzForumGroupTopic.setUserId(qzUsers1.getId());
                qzForumGroupTopic.setBrowNum(25);
                qzForumGroupTopic.setAppreciateNum(26);
                qzForumGroupTopic.setCommentNum(27);
                iQzForumGroupTopicService.insert(qzForumGroupTopic);
            }
        }


    }
}