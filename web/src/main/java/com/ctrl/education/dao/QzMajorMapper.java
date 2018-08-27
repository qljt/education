package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.QzMajor;
import com.ctrl.education.model.QzPaper;

import java.util.List;

/**
 * <p>
 * 专业表 Mapper 接口
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface QzMajorMapper extends BaseMapper<QzMajor> {
    List<QzMajor> selectMajor();

    QzMajor getMajorById(String id);
}
