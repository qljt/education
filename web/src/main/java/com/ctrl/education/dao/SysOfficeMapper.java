package com.ctrl.education.dao;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.model.SysOffice;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 机构表 Mapper 接口
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
public interface SysOfficeMapper extends BaseMapper<SysOffice> {
    /**
     * 获取ztree的节点列表
     */
    List<ZTreeNode> tree();
}
