
package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzCertificateTemplateMapper;
import com.ctrl.education.dao.QzUsersMapper;
import com.ctrl.education.model.QzCertificateTemplate;
import com.ctrl.education.model.QzUsers;
import com.ctrl.education.service.IQzCertificateTemplateService;
import com.ctrl.education.service.IQzUsersService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 培训证书模板表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@Service
public class QzCertificateTemplateServiceImpl extends ServiceImpl<QzCertificateTemplateMapper, QzCertificateTemplate> implements IQzCertificateTemplateService {
    @Override
    public Result selectTemplate() {
        List<QzCertificateTemplate> qzCertificateTemplateList = this.baseMapper.selectTemplate();
        if (qzCertificateTemplateList.size() > 0) {
            return Result.ok().put("msg", SystemConstant.QUERY_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", qzCertificateTemplateList);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
    }
}
