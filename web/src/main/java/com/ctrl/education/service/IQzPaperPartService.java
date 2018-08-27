package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaper;
import com.ctrl.education.model.QzPaperPart;

import java.util.Map;

/**
 * <p>
 * 试题区块表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzPaperPartService extends IService<QzPaperPart> {
    Result add(QzPaperPart qzPaperPart);
}
