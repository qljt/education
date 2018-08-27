package com.ctrl.education.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzExaminationMapper;
import com.ctrl.education.model.QzExamination;
import com.ctrl.education.service.IQzExaminationService;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 考试安排表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzExaminationServiceImpl extends ServiceImpl<QzExaminationMapper, QzExamination> implements IQzExaminationService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result add(QzExamination qzExamination) {
        if (qzExamination.getId() == null) {
            int count = this.baseMapper.insert(qzExamination);
            if (count > 0) {
                return Result.ok().put("msg", SystemConstant.ADD_SUCCESS).put("code", SystemConstant.SUCCESS);
            }
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
    }

    @Override
    public Result list(Map<String, Object> map) {
//        String type = (String) map.get("type");
//        String teacherName = (String) map.get("teacherName");
        String name = (String) map.get("name");
        Page<QzExamination> page = this.selectPage(
                new Query<QzExamination>(map).getPage(),
                new EntityWrapper<QzExamination>()
//                        .eq(StringUtils.isNotEmpty(type), "type", type)
//                        .eq(StringUtils.isNotEmpty(teacherName), "teacher_name", teacherName)
                        .like(StringUtils.isNotEmpty(name), "name", name)
                        .eq(true, "state", 1)
        );
        return new PageUtils(page).toLayTableResult();
    }

    @Override
    public Result addExamination(QzExamination qzExamination) {
        qzExamination.setSysUserId(ShiroKit.getUser().getId());
        qzExamination.setCreatetime(DateUtil.now());
        if (qzExamination.getId() == null) {
            int count = this.baseMapper.insert(qzExamination);
            if (count > 0) {
                return Result.ok().put("msg", SystemConstant.ADD_SUCCESS).put("code", SystemConstant.SUCCESS);
            }
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
    }

    @Override
    public Result remove(String id) {
        int count = this.baseMapper.remove(id);
        if (count > 0) {
            return Result.ok().put("msg", SystemConstant.DELETE_SUCCESS).put("code", SystemConstant.SUCCESS);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.DELETE_FAILURE);
    }
}
