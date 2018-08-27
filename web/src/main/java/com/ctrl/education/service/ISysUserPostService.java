package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysUserPost;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
public interface ISysUserPostService extends IService<SysUserPost> {

    boolean setUserPost(String userId, String postId);
}
