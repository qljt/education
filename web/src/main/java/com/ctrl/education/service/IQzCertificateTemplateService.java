package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzCertificateTemplate;
import com.ctrl.education.model.QzCourseware;

/**
 * <p>
 * 培训证书模板表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzCertificateTemplateService extends IService<QzCertificateTemplate> {
    Result selectTemplate();
}
