package com.ctrl.education.service.impl;

import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysRole;
import com.ctrl.education.dao.SysRoleMapper;
import com.ctrl.education.service.ISysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result add(SysRole sysRole) {
        boolean flag = this.insert(sysRole);
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
    public Result modify(SysRole sysRole) {
        boolean flag = this.updateById(sysRole);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override
    public Result tree() {
        List<ZTreeNode> tree = this.baseMapper.tree();
        tree.add(ZTreeNode.createParent());
        return Result.ok().put(SystemConstant.RESULT_KEY,tree);
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result remove(String id) {
        boolean flag = this.deleteById(id);
        if (flag) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }
}
