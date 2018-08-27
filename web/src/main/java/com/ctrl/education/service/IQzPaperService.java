package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzCouChapter;
import com.ctrl.education.model.QzPaper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 试卷/问卷调查表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzPaperService extends IService<QzPaper> {

    Result list(Map<String,Object> map);

    Result add(QzPaper qzPaper);

    Result deleteById(String id);

    Result selectPaper();
}
