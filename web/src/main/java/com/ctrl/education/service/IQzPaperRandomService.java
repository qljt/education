package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaperQuestionType;
import com.ctrl.education.model.QzPaperRandom;

/**
 * <p>
 * 随机卷抽题规则表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzPaperRandomService extends IService<QzPaperRandom> {
    Result add(QzPaperRandom qzPaperRandom);
}
