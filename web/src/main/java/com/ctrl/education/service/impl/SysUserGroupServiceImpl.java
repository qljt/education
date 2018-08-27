package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.dao.SysUserGroupMapper;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.model.SysUserGroup;
import com.ctrl.education.service.ISysUserGroupService;
import com.ctrl.education.service.ISysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SysUserGroupServiceImpl extends ServiceImpl<SysUserGroupMapper, SysUserGroup> implements ISysUserGroupService {
    @Autowired
    private ISysUserService iSysUserService;

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean setUserGroup(String id, String groupIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", id);
        List<SysUserGroup> sysUserGroupList = this.selectByMap(map);
        if (ToolUtils.isNotEmpty(sysUserGroupList)) {
            this.deleteByMap(map);
            boolean flag = this.setUserGroups(id, groupIds);
            return flag;
        } else {
            boolean flag = this.setUserGroups(id, groupIds);
            return flag;
        }
    }

    private boolean setUserGroups(String id, String groupIds) {
        String[] ids = groupIds.split(",");
        int count = 0;
        for (String groupId : ids) {
            SysUserGroup sysUserGroup = new SysUserGroup();
            sysUserGroup.setUserId(String.valueOf(id));
            sysUserGroup.setGroupId(groupId);
            boolean flag = this.insert(sysUserGroup);
            if (flag) {
                count++;
            }
        }
        if (ids.length == count) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<SysUserGroup> selectGroupByUseryId(String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<SysUserGroup> list = this.selectByMap(map);
        return list;
    }

    @Override
    public List<ZTreeNode> groupTreeListByUserId(String userId) {
        return baseMapper.groupTreeListByUserId(userId);
    }

    @Override
    public Result getList(Map<String, Object> map) {
        String groupId = (String) map.get("groupId");
        if (StringUtils.isEmpty(groupId)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        String username = (String) map.get("username");
        String officeId = (String) map.get("office_id");
        // 获取总条数
        List<Map<String, Object>> list = baseMapper.getList(map);
        Page<SysUser> page = iSysUserService.selectPage(
                new Query<SysUser>(map).getPage(),
                new EntityWrapper<SysUser>()
                        .eq(StringUtils.isNotEmpty(officeId), "office_id", officeId)
                        .like(StringUtils.isNotEmpty(username), "username", username)
        );
        Integer totalCount = page.getRecords().size();
        return new Result().ok()
                .put("total", totalCount)
                .put("rows", list);
    }

    @Override
    public List getListByGroupId(String groupId) {
        List list = baseMapper.getListByGroupId(groupId);
        return list;
    }

    @Override
    public List<Map<String, Object>> getNotInGroupList(String groupId) {
        List<Map<String, Object>> list = baseMapper.getNotInGroupList(groupId);
        return list;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result add(SysUserGroup sysUserGroup) {
        List<SysUserGroup> list = sysUserGroup.getSysUserGroupList();
        if (ToolUtils.isEmpty(list)){
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        int count = 0;
        for (SysUserGroup sysUserGroup1:list){
            boolean flag = this.insert(sysUserGroup1);
            if(flag){
                count++;
            }
        }
        if(count==list.size()){
            return Result.ok(SystemConstant.ADD_SUCCESS);
        }else{
            return Result.ok(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result remove(String id) {
       boolean flag =  this.deleteById(id);
      if(flag){
           return Result.ok(SystemConstant.DELETE_SUCCESS);
      }else{
          return Result.error(SystemConstant.DELETE_FAILURE);
      }
    }
}
