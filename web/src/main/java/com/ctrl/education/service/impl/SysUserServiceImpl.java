package com.ctrl.education.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.dao.SysUserMapper;
import com.ctrl.education.dao.SysUserOfficeMapper;
import com.ctrl.education.dto.SysUserOfficeDto;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.model.SysUserOffice;
import com.ctrl.education.service.ISysUserGroupService;
import com.ctrl.education.service.ISysUserOfficeService;
import com.ctrl.education.service.ISysUserPostService;
import com.ctrl.education.service.ISysUserService;
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
 * 系统用户表 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    private ISysUserPostService iSysUserPostService;
    @Autowired
    ISysUserGroupService iSysUserGroupService;
    @Autowired
    ISysUserOfficeService iSysUserOfficeService;

    @Override
    public Result getList(Map<String, Object> map) {
        String username = (String) map.get("username");
        String officeId = (String) map.get("office_id");
        // 获取总条数
        List<Map<String, Object>> list = baseMapper.getList(map);
        Page<SysUser> page = this.selectPage(
                new Query<SysUser>(map).getPage(),
                new EntityWrapper<SysUser>()
                        .like(StringUtils.isNotEmpty(username), "username", username)
        );
        Integer totalCount = Integer.parseInt(String.valueOf(page.getTotal()));
        return new Result().ok()
                .put("total", totalCount)
                .put("rows", list);
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(SysUser sysUser) {
        ValidatorUtils.validateEntity(sysUser, AddGroup.class);
        sysUser.setPassword(SecureUtil.md5(sysUser.getPassword()));
        boolean flag = this.getUserByUsername(sysUser.getUsername(),"0");
        if (flag) {
            return Result.error(SystemConstant.USER_NAME_IS_EXIST);
        }
        boolean inserFlag = this.insert(sysUser);
        if (inserFlag) {
            List<SysUserOffice> sysUserOfficeList = sysUser.getExtendInfo();
            if (!ToolUtils.isEmpty(sysUserOfficeList)) {
                //sysUserOfficeList是否为空，如果为空，那么用户表插入成功也提示新增成功，如果不为空则遍历扩展信息，循环插入sysuserinfo表
                if (this.insertSysUserOffice(sysUser, sysUserOfficeList)) {
                    return Result.ok(SystemConstant.ADD_SUCCESS);
                } else {
                    return Result.error(SystemConstant.ADD_FAILURE);
                }
            } else {
                return Result.ok(SystemConstant.ADD_SUCCESS);
            }
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result modify(SysUser sysUser) {
        ValidatorUtils.validateEntity(sysUser, UpdateGroup.class);

        boolean flag = this.getUserByUsername(sysUser.getUsername(),sysUser.getId());
        if (flag) {
            return Result.error(SystemConstant.USER_NAME_IS_EXIST);
        }
        boolean updateFlag = this.updateById(sysUser);
        if (updateFlag) {
            List<SysUserOffice> sysUserOfficeList = sysUser.getExtendInfo();
            if (ToolUtils.isNotEmpty(sysUserOfficeList)) {
                List<String> list = new ArrayList();
                //取出所有在sys_user_office中存在的记录
                for (SysUserOffice sysUserOffice : sysUserOfficeList) {
                    if (StringUtils.isNotEmpty(sysUserOffice.getId())) {
                        list.add(sysUserOffice.getId());
                    }
                }
                //如果在sys_user_office中存在则全部删除
                if(ToolUtils.isNotEmpty(list)){
                    iSysUserOfficeService.deleteBatchIds(list);
                }
                if (this.insertSysUserOffice(sysUser, sysUserOfficeList)) {
                    return Result.ok(SystemConstant.UPDATE_SUCCESS);
                } else {
                    return Result.error(SystemConstant.UPDATE_FAILURE);
                }
            } else {
                return Result.ok(SystemConstant.UPDATE_SUCCESS);
            }
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result remove(String id) {
        SysUser sysUser = this.selectById(id);
        if (sysUser.getUsername().equals(SystemConstant.USER_ADMIN)) {
            return Result.error("不允许删除超级管理员");
        }
        Integer count = this.baseMapper.deleteById(id);
        if (count > 0) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public Result getSysUser(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        SysUser sysUser = baseMapper.selectById(id);
        List<SysUserOfficeDto> list = this.baseMapper.selectUserOfficeById(id);
        sysUser.setSysUserOfficeDtos(list);
        return Result.ok().put(SystemConstant.RESULT_KEY, sysUser);
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result resetPWD(Map<String, Object> map) {
        String id = (String) map.get("resetPwdUserId");
        String newPWd = (String) map.get("newPWd");
        String confirmPassword = (String) map.get("confirmPassword");
        if (StringUtils.isEmpty(newPWd) || StringUtils.isEmpty(confirmPassword)) {
            return Result.error("新密码或者确认密码为空");
        }
        if (!StringUtils.equals(newPWd, confirmPassword)) {
            return Result.error("新密码跟确认密码不一致");
        }
        if (StringUtils.isEmpty(id)) {
            return Result.error("尚未传入用户id");
        }
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setPassword(SecureUtil.md5(newPWd));
        Integer count = this.baseMapper.updateById(sysUser);
        if (count > 0) {
            return Result.ok(SystemConstant.RESET_PWD_SUCCESS);
        } else {
            return Result.error(SystemConstant.RESET_PWD_FAILURE);
        }
    }

    private boolean getUserByUsername(String username,String id) {
        Integer count = this.baseMapper.selectCount(
                new EntityWrapper<SysUser>()
                        .ne("id",id)
                        .eq("username", username)
        );
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    @Override
    public Result updateSysUserStatus(Map<String, Object> map) {
        String userId = (String) map.get("userId");
        String status = (String) map.get("status");
        if (StringUtils.isEmpty(userId)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setStatus(Integer.parseInt(status));
        boolean flag = this.updateById(sysUser);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    private boolean insertSysUserOffice(SysUser sysUser, List<SysUserOffice> sysUserOfficeList) {
        int count = 0;
        for (SysUserOffice sysUserOffice : sysUserOfficeList) {
            sysUserOffice.setSysUserId(sysUser.getId());
            boolean flag = iSysUserOfficeService.insert(sysUserOffice);
            if (flag) {
                count++;
            }
        }
        if (sysUserOfficeList.size() == count) {
            return true;
        } else {
            return false;
        }
    }
}
