package com.ctrl.education.dao;

import com.ctrl.education.model.QzAppApkversions;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
public interface QzAppApkversionsMapper extends BaseMapper<QzAppApkversions> {

    void updateIsNotNew(Map<String,Object> map);

}
