package com.ctrl.education.service;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysPost;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 岗位表 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-23
 */
public interface ISysPostService extends IService<SysPost> {

    Map<String,Object> selectPostById(String id);

    Result remove(String id);

    Result modify(SysPost sysPost);

    Result save(SysPost sysPost);

    List<Map<String,Object>> getList(Map<String,Object> map);

    Result tree();

    List<ZTreeNode> postTreeList();

    List<ZTreeNode> postTreeListByUserId(String userId);

    Result postSelect();
}
