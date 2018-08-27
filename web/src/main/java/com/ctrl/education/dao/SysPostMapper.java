package com.ctrl.education.dao;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.model.SysPost;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 岗位表 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-07-23
 */
public interface SysPostMapper extends BaseMapper<SysPost> {

    List<ZTreeNode> tree();

    Map<String,Object> selectPostById(String id);

    List<ZTreeNode> postTreeList();

    List<ZTreeNode> postTreeListByUserId(@Param("userId") String userId);

    List<Map<String,Object>> postSelect();
}
