package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzCouChapter;
import com.ctrl.education.model.QzExamination;

import java.util.Map;

/**
 * <p>
 * 考试安排表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzExaminationService extends IService<QzExamination> {

    Result add(QzExamination qzExamination);

    Result list(Map<String, Object> map);

    Result addExamination(QzExamination qzExamination);

    Result remove(String id);
}
