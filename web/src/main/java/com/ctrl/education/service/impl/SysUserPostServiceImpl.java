package com.ctrl.education.service.impl;

import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.model.SysUserPost;
import com.ctrl.education.dao.SysUserPostMapper;
import com.ctrl.education.model.SysUserRole;
import com.ctrl.education.service.ISysUserPostService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
@Service
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostMapper, SysUserPost> implements ISysUserPostService {
    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean setUserPost(String id, String postIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", id);
        List<SysUserPost> sysUserRoleList = this.selectByMap(map);
        if (ToolUtils.isNotEmpty(sysUserRoleList)) {
            this.deleteByMap(map);
            boolean flag = this.setUserPosts(id, postIds);
            return flag;
        } else {
            boolean flag = this.setUserPosts(id, postIds);
            return flag;
        }
    }

    private boolean setUserPosts(String id, String postIds) {
        String[] ids = postIds.split(",");
        int count =0;
        for (String postId : ids) {
            SysUserPost sysUserPost = new SysUserPost();
            sysUserPost.setUserId(String.valueOf(id));
            sysUserPost.setPostId(String.valueOf(postId));
            boolean flag = this.insert(sysUserPost);
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
