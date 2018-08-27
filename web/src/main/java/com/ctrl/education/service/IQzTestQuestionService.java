package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzQuestionBank;
import com.ctrl.education.model.QzTestQuestions;

/**
 * <p>
 * 题库表 服务类
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
public interface IQzTestQuestionService extends IService<QzTestQuestions> {
    Result add(QzTestQuestions qzTestQuestions);
}
