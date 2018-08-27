package com.ctrl.education.dao;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.model.SysGroup;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户分组 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
public interface SysGroupMapper extends BaseMapper<SysGroup> {
    List<ZTreeNode> tree();

    Map<String,Object> selectGroupById(String id);

    List<ZTreeNode> groupTreeList();

    List<ZTreeNode> groupTreeListByUserId(@Param("userId") String userId);
}
