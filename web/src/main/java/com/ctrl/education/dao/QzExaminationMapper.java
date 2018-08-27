package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.QzExamination;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 考试安排表 Mapper 接口
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface QzExaminationMapper extends BaseMapper<QzExamination> {
    List<Map<String, Object>> getList(Map<String, Object> map);

    int remove(String id);
}
