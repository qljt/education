package com.ctrl.education.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dto.SysUserDto;
import com.ctrl.education.model.QzEnterprise;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.dao.SysUserMapper;
import com.ctrl.education.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Override
    public Result getList(Map<String, Object> map) {
        String username = (String) map.get("username");
        Page<SysUser> page = this.selectPage(
                new Query<SysUser>(map).getPage(),
                new EntityWrapper<SysUser>()
                        .like(StringUtils.isNotBlank(username), "username", username)
                        .orderBy("createtime", true)
        );
        return new PageUtils(page).toLayTableResult();
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(SysUser sysUser) {
        sysUser.setPassword(SecureUtil.md5(sysUser.getPassword()));
        boolean flag = this.getUserByUsername(sysUser);
        if(flag){
            return Result.error(SystemConstant.USER_NAME_IS_EXIST);
        }
       Integer count =  baseMapper.insert(sysUser);
        if (count > 0) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result modify(SysUser sysUser) {
        Integer count = this.baseMapper.updateById(sysUser);
        if (count > 0) {
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
        Integer count =  this.baseMapper.deleteById(id);
        if (count > 0) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public Result getSysUser(String id) {
       SysUser sysUser =  this.baseMapper.selectById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY,sysUser);
    }

    private boolean getUserByUsername(SysUser sysUser){
       Integer count =  this.baseMapper.selectCount(
                new EntityWrapper<SysUser>().eq("username",sysUser.getUsername())
        );
       if(count>0){
           return true;
       }
       return false;
    }

}
