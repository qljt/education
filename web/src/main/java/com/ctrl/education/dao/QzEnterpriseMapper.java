package com.ctrl.education.dao;

import com.ctrl.education.dto.QzEnterpriseDto;
import com.ctrl.education.model.QzEnterprise;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业表 Mapper 接口
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
public interface QzEnterpriseMapper extends BaseMapper<QzEnterprise> {

    List<QzEnterpriseDto> getList(Map<String, Object> params);
}
