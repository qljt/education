package com.ctrl.education.service;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysGroup;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户分组 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
public interface ISysGroupService extends IService<SysGroup> {
    Result tree();

    List<Map<String,Object>> getList(Map<String,Object> map);

    Result save(SysGroup sysGroup);

    Result modify(SysGroup sysGroup);

    Result remove(String id);

    Map<String,Object> selectGroupById(String id);

    List<ZTreeNode> groupTreeList();

    List<ZTreeNode> groupTreeListByUserId(String userId);
}
