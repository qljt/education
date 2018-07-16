package com.ctrl.education.dao;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.model.SysDict;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-07-15
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    List<ZTreeNode> getTree();
}
