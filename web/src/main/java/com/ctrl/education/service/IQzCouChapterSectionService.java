package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzCouChapter;
import com.ctrl.education.model.QzCouChapterSection;

/**
 * <p>
 * 小节表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzCouChapterSectionService extends IService<QzCouChapterSection>{

    Result addChapterSection(QzCouChapterSection qzCouChapterSection);
}
