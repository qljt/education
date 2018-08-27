package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaperFixed;
import com.ctrl.education.model.QzPaperQuestionType;

/**
 * <p>
 * 试卷题型表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzPaperQuestionTypeService extends IService<QzPaperQuestionType> {
    Result add(QzPaperQuestionType qzPaperQuestionType);
}
