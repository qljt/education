package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzForumGroup;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 论坛小组 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
public interface IQzForumGroupService extends IService<QzForumGroup> {

    Result getInfo(String id);

    Result getList(Map<String,Object> param);

    Result save(QzForumGroup qzForumGroup);

    Result modify(QzForumGroup qzForumGroup);

    Result remove(QzForumGroup qzForumGroup);

    Result disable(QzForumGroup qzForumGroup);

}
