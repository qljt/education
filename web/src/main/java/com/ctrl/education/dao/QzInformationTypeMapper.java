package com.ctrl.education.dao;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.model.QzInformationType;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资讯分类 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
public interface QzInformationTypeMapper extends BaseMapper<QzInformationType> {

    List<ZTreeNode> tree(String param);

    Map<String, Object> selectQzInformationTypeById(String id);
}
