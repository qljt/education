package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.model.SysGroup;
import com.ctrl.education.dao.SysGroupMapper;
import com.ctrl.education.service.ISysGroupService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户分组 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
@Service
public class SysGroupServiceImpl extends ServiceImpl<SysGroupMapper, SysGroup> implements ISysGroupService {
    @Override
    public Result tree() {
        List<ZTreeNode> tree = this.baseMapper.tree();
        tree.add(ZTreeNode.createParent());
        return Result.ok().put(SystemConstant.RESULT_KEY, tree);
    }

    @Override
    public List<Map<String, Object>> getList(Map<String, Object> map) {
        String name = (String) map.get("name");
        List<Map<String, Object>> list = this.selectMaps(new EntityWrapper<SysGroup>()
                .like(StringUtils.isNotBlank(name), "group_name", name));

        return list;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(SysGroup sysGrup) {

        if (StringUtils.isEmpty(sysGrup.getPid()) || sysGrup.getPid().equals("0")) {
            sysGrup.setPid("0");
        }
        boolean flag = this.insert(sysGrup);
        if (flag) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result modify(SysGroup sysGrup) {
        if (StringUtils.isEmpty(sysGrup.getPid()) || sysGrup.getPid().equals(0)) {
            sysGrup.setPid("0");
        }
        boolean flag = this.updateById(sysGrup);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result remove(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        List<Map<String, Object>> list = this.selectMaps(new EntityWrapper<SysGroup>()
                .where("id={0}", id));
        if (ToolUtils.isNotEmpty(list)) {
            return Result.error(SystemConstant.EXSIT_CHILD_MENU);
        }
        boolean flag = this.deleteById(id);
        if (flag) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public Map<String, Object> selectGroupById(String id) {
        Map<String, Object> map =   baseMapper.selectGroupById(id);
        return map;
    }

    @Override
    public List<ZTreeNode> groupTreeList() {
        return baseMapper.groupTreeList();
    }

    @Override
    public List<ZTreeNode> groupTreeListByUserId(String userId) {
       return baseMapper.groupTreeListByUserId(userId);
    }
}
