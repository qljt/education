package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.QzPaperQuestionType;

import java.util.List;

/**
 * <p>
 * 试卷题型表 Mapper 接口
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface QzPaperQuestionTypeMapper extends BaseMapper<QzPaperQuestionType> {
    List<QzPaperQuestionType> listByPaperId(String paperId,String alias);
}
