package com.ctrl.education.dao;

import com.ctrl.education.model.QzInformation;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 动态资讯 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
public interface QzInformationMapper extends BaseMapper<QzInformation> {

    int remove(String id);

    Map<String,Object> getInfo(String id);

    List<Map<String,Object>> getList(Map<String,Object> param);
}
