package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.dao.QzPaperPartMapper;
import com.ctrl.education.dao.QzTestQuestionAnswerMapper;
import com.ctrl.education.model.QzPaperPart;
import com.ctrl.education.model.QzTestQuestionAnswer;
import com.ctrl.education.service.IQzPaperPartService;
import com.ctrl.education.service.IQzPaperQuestionTypeService;
import com.ctrl.education.service.IQzTestQuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 客观题答案表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzTestQuestionAnswerServiceImpl extends ServiceImpl<QzTestQuestionAnswerMapper, QzTestQuestionAnswer> implements IQzTestQuestionAnswerService {
    @Autowired
    private IQzTestQuestionAnswerService iQzTestQuestionAnswerService;

    @Override
    public Result add(QzTestQuestionAnswer qzTestQuestionAnswer) {
        if (qzTestQuestionAnswer.getId() == null){
            int count = this.baseMapper.insert(qzTestQuestionAnswer);
            if (count>0){
                return Result.ok().put("msg",SystemConstant.ADD_SUCCESS).put("code",SystemConstant.SUCCESS);
            }
            return Result.error(SystemConstant.ERROR_CODE,SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE,SystemConstant.ADD_FAILURE);
    }
}
