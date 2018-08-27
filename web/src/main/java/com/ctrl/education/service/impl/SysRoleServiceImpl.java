package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.dao.SysRoleMapper;
import com.ctrl.education.dto.SysRoleDto;
import com.ctrl.education.model.SysRelation;
import com.ctrl.education.model.SysRole;
import com.ctrl.education.model.SysUserRole;
import com.ctrl.education.service.ISysRelationService;
import com.ctrl.education.service.ISysRoleService;
import com.ctrl.education.service.ISysUserRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private ISysRoleService iSysRoleService;
    @Autowired
    private ISysUserRoleService iSysUserRoleService;

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
        //this.roleSetPids(sysRole);
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
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        iSysRoleService.deleteRolesById(roleId);
        String[] idss = ids.split(",");
        int count = 0;
        for (String id : idss) {
            SysRelation sysRelation = new SysRelation();
            sysRelation.setRoleid(roleId);
            sysRelation.setMenuid(String.valueOf(id));
            boolean bool = iSysRelationService.insert(sysRelation);
            if (bool) {
                count++;
            }
        }
        if (idss.length == count) {
            return Result.ok(SystemConstant.ALLOT_AUTH_SUCCESS_MSG);
        } else {
            return Result.error(SystemConstant.ALLOT_AUTH_FAILE_MSG);
        }
    }

    @Override
    public Result roleTreeListByUserId(String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<SysUserRole> list = iSysUserRoleService.selectByMap(map);
        if (ToolUtils.isEmpty(list)) {
            List<ZTreeNode> roleTreeList = this.iSysRoleService.roleTreeList();
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeList);
        } else {
            List<String> roleList=new ArrayList<>();
            for (SysUserRole sysUserRole:list) {
                roleList.add(sysUserRole.getRoleId());
            }
            String[] strings = new String[roleList.size()];
            List<ZTreeNode> roleTreeListByUserId = this.iSysRoleService.roleTreeListByRoleId(roleList.toArray(strings));
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeListByUserId);
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

    @Override
    public SysRoleDto selectByRoleId(String id) {
        SysRoleDto sysRoleDto = baseMapper.selectByRoleId(id);
        return sysRoleDto;
    }

    private void roleSetPids(SysRole sysRole) {
        if (StringUtils.isEmpty(sysRole.getPid()) || sysRole.getPid().equals("0")) {
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

    @Override
    public int deleteRolesById(String roleId) {
        int count = baseMapper.deleteRolesById(roleId);
        return count;
    }

    @Override
    public List<ZTreeNode> roleTreeList() {
        return baseMapper.roleTreeList();
    }

    @Override
    public List<ZTreeNode> roleTreeListByRoleId(String[] roleId) {
        return this.baseMapper.roleTreeListByRoleId(roleId);
    }

}
