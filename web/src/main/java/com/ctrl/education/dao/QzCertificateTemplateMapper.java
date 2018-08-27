package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.QzCertificateTemplate;

import java.util.List;

/**
 * <p>
 * 培训证书模板表 Mapper 接口
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
public interface QzCertificateTemplateMapper extends BaseMapper<QzCertificateTemplate> {
    List<QzCertificateTemplate> selectTemplate();
}
