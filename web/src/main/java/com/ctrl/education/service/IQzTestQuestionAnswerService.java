package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaperQuestionType;
import com.ctrl.education.model.QzTestQuestionAnswer;

/**
 * <p>
 * 客观题答案表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzTestQuestionAnswerService extends IService<QzTestQuestionAnswer> {
    Result add(QzTestQuestionAnswer qzTestQuestionAnswer);
}
