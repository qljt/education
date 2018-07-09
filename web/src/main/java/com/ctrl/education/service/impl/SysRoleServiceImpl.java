package com.ctrl.education.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.dto.SysRoleDto;
import com.ctrl.education.model.QzEnterprise;
import com.ctrl.education.model.SysRelation;
import com.ctrl.education.model.SysRole;
import com.ctrl.education.dao.SysRoleMapper;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.service.ISysRelationService;
import com.ctrl.education.service.ISysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.service.ISysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ISysRelationService iSysRelationService;
    @Autowired
    private ISysUserService iSysUserService;

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result add(SysRole sysRole) {
        this.roleSetPids(sysRole);
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
        this.roleSetPids(sysRole);
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
        return Result.ok().put(SystemConstant.RESULT_KEY, tree);
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result remove(String id) {
        if (hasRelation(id)) {
            return Result.error("请删除绑定的权限，再删除");
        }
        boolean flag = this.deleteById(id);
        if (flag) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result setAuthority(String roleId, String ids) {
        if (StringUtils.isEmpty(roleId)) {
            return Result.error("请求错误");
        }
        boolean flag = iSysRelationService.deleteById(roleId);
        if (flag) {
            String[] idss = ids.split(",");
            for (String id:idss) {
                SysRelation sysRelation = new SysRelation();
                sysRelation.setRoleid(roleId);
                sysRelation.setMenuid(String.valueOf(id));
                iSysRelationService.insert(sysRelation);
            }
        }
        return null;
    }

    @Override
    public Result roleTreeListByUserId(String userId) {
        SysUser sysUser = iSysUserService.selectById(userId);
        String roleId = sysUser.getRoleId();
        if (StringUtils.isEmpty(roleId)) {
            return this.tree();
        } else {
            String[] roleIds = roleId.split(",");
            List<ZTreeNode> list = this.baseMapper.roleTreeListByRoleId(roleIds);
            return Result.ok().put(SystemConstant.RESULT_KEY, list);
        }
    }

    @Override
    public Result getList(Map<String, Object> map) {
//        String offset = (String)map.get("offset");
//        map.put("offset",offset);
        List<SysRoleDto> list = baseMapper.getList(map);
        // 获取总条数
        Integer totalCount = baseMapper.selectCount(new EntityWrapper<SysRole>());
        return new Result().ok()
                .put("total", totalCount)
                .put("rows", list);
    }

    /**
     * 根据角色id查询角色绑定的角色
     *
     * @param roleid
     * @return
     */
    private boolean hasRelation(String roleid) {

        SysRelation sysRelation = iSysRelationService.selectById(roleid);
        if (null != sysRelation) {
            return true;
        }
        return false;
    }

    private void roleSetPids(SysRole sysRole) {
        if (StringUtils.isEmpty(sysRole.getPid()) || sysRole.getPid().equals(0)) {
            sysRole.setPid("0");
            sysRole.setPids("0,");
        } else {
            String pid = sysRole.getPid();
            SysRole temp = this.selectById(pid);
            String pids = temp.getPids();
            sysRole.setPid(pid);
            sysRole.setPids(pids + "" + pid + ",");
        }
    }


}
