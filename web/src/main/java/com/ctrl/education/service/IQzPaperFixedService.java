package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaper;
import com.ctrl.education.model.QzPaperFixed;

import java.util.Map;

/**
 * <p>
 * 固定卷试卷题目表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzPaperFixedService extends IService<QzPaperFixed> {
    Result add(QzPaperFixed qzPaperFixed);
}
