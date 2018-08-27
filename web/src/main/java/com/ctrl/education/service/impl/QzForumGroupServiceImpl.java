package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.AlohaDateUtils;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.dao.QzForumGroupUsersMapper;
import com.ctrl.education.model.QzForumGroup;
import com.ctrl.education.dao.QzForumGroupMapper;
import com.ctrl.education.model.QzForumGroupUsers;
import com.ctrl.education.service.IQzForumGroupService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 论坛小组 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
@Service
public class QzForumGroupServiceImpl extends ServiceImpl<QzForumGroupMapper, QzForumGroup> implements IQzForumGroupService {
    @Autowired
    private QzForumGroupUsersMapper qzForumGroupUsersMapper;

    @Override
    public Result getList(Map<String, Object> param) {
        String name = (String) param.get("name");
        // 获取总条数
        List<Map<String, Object>> list = baseMapper.getLists(param);
        Page<QzForumGroup> page = this.selectPage(
                new Query<QzForumGroup>(param).getPage(),
                new EntityWrapper<QzForumGroup>()
                        .ne("state", 0)
                        .like(StringUtils.isNotBlank(name), "name", name)
                        .orderBy("createtime",true)

        );
        Integer totalCount = Integer.parseInt(String.valueOf(page.getTotal()));
        return new Result().ok()
                .put("total", totalCount)
                .put("rows", list);
    }

    @Override
    public Result getInfo(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        QzForumGroup qzForumGroup = this.selectById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY, qzForumGroup);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    @Override
    public Result save(QzForumGroup qzForumGroup) {
        ValidatorUtils.validateEntity(qzForumGroup, AddGroup.class);
        qzForumGroup.setCreatetime(AlohaDateUtils.getDay());
        qzForumGroup.setSysUserId(ShiroKit.getUser().getId());
        boolean flag = this.insert(qzForumGroup);
        if (flag) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }

    }
    @Transactional(
            rollbackFor = {Exception.class}
    )
    @Override
    public Result modify(QzForumGroup qzForumGroup) {
        ValidatorUtils.validateEntity(qzForumGroup, UpdateGroup.class);
        if (StringUtils.isEmpty(qzForumGroup.getId())) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        qzForumGroup.setSysUserId(ShiroKit.getUser().getId());
        boolean flag = this.update(qzForumGroup);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }
    @Transactional(
            rollbackFor = {Exception.class}
    )
    @Override
    public Result remove(QzForumGroup qzForumGroup) {
        if (StringUtils.isEmpty(qzForumGroup.getId())) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }

        Integer count = qzForumGroupUsersMapper.selectCount(
                new EntityWrapper<QzForumGroupUsers>()
                        .eq("group_id", qzForumGroup.getId())
        );
        if (count > 0) {
            return Result.error(SystemConstant.EXSIT_CHILD_MENU);
        }
        qzForumGroup.setSysUserId(ShiroKit.getUser().getId());
        boolean flag = this.update(qzForumGroup);
        if (flag) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }
    @Transactional(
            rollbackFor = {Exception.class}
    )
    @Override
    public Result disable(QzForumGroup qzForumGroup) {
        if (StringUtils.isEmpty(qzForumGroup.getId())) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        qzForumGroup.setSysUserId(ShiroKit.getUser().getId());
        Integer state = qzForumGroup.getState();
        boolean flag = this.update(qzForumGroup);
        if (flag) {
            if(state==1){
                return Result.ok(SystemConstant.ENABLE_SUCCESS);
            }
            return Result.ok(SystemConstant.DISABLE_SUCCESS);
        } else {
            if(state==2){
                return Result.ok(SystemConstant.ENABLE_FAILURE);
            }
            return Result.error(SystemConstant.DISABLE_FAILURE);
        }
    }
    /**
     * 公共修改方法
     *
     * @param qzForumGroup
     * @return
     */
    private boolean update(QzForumGroup qzForumGroup) {

        return this.updateById(qzForumGroup);
    }
}
