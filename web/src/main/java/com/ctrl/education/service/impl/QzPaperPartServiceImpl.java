package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.dao.QzPaperPartMapper;
import com.ctrl.education.model.QzCourseware;
import com.ctrl.education.model.QzPaperPart;
import com.ctrl.education.model.QzPaperQuestionType;
import com.ctrl.education.service.IQzPaperPartService;
import com.ctrl.education.service.IQzPaperQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 试题区块表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzPaperPartServiceImpl extends ServiceImpl<QzPaperPartMapper, QzPaperPart> implements IQzPaperPartService {
    @Autowired
    private IQzPaperQuestionTypeService iQzPaperQuestionTypeService;

    @Override
    public Result add(QzPaperPart qzPaperPart) {
        ValidatorUtils.validateEntity(qzPaperPart);
        if (qzPaperPart.getId() == null) {
            List<QzPaperPart> qzPaperPartList = this.baseMapper.paperPartInfo(qzPaperPart);
            if (qzPaperPartList.isEmpty()) {
                int count = this.baseMapper.insert(qzPaperPart);
                String id = qzPaperPart.getId();
                if (count > 0) {
                    return Result.ok().put("msg", SystemConstant.ADD_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", id);
                }
                return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
            }
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
    }
}
