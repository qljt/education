package com.ctrl.education.dao;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.dto.OfficeChartDto;
import com.ctrl.education.model.SysOffice;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    List<ZTreeNode> officeTree();

    List<Map<String, Object>> getList(Map<String, Object> map);

    Map<String, Object> selectOfficeById(String id);

    List<Map<String, Object>> deptTree();

    List<Map<String, Object>> officeSelect();

    List<SysOffice> selectOfficeByType(Integer type);

    SysOffice getDeptByCode(String code);
}
