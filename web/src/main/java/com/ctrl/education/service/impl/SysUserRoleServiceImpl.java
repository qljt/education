package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.dao.SysUserRoleMapper;
import com.ctrl.education.model.SysUserRole;
import com.ctrl.education.service.ISysUserRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result setRole(String id, String roleIds) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(roleIds)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", id);
        List<SysUserRole> sysUserRoleList = this.selectByMap(map);
        if (ToolUtils.isNotEmpty(sysUserRoleList)) {
            this.deleteByMap(map);
            boolean flag = this.setRoles(id, roleIds);
            if (flag) {
                return Result.ok(SystemConstant.ALLOT_ROLE_SUCCESS_MSG);
            } else {
                return Result.error(SystemConstant.ALLOT_ROLE_FAILE_MSG);
            }
        } else {
            boolean flag = this.setRoles(id, roleIds);
            if (flag) {
                return Result.ok(SystemConstant.ALLOT_ROLE_SUCCESS_MSG);
            } else {
                return Result.error(SystemConstant.ALLOT_ROLE_FAILE_MSG);
            }
        }
    }

    private boolean setRoles(String id, String roleIds) {
        String[] ids = roleIds.split(",");
        int count =0;
        for (String str : ids) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(String.valueOf(id));
            sysUserRole.setRoleId(str);
            boolean flag = this.insert(sysUserRole);
            if(flag){
                count++;
            }
        }
        if(ids.length==count){
            return true;
        }else{
            return false;
        }
    }
}
