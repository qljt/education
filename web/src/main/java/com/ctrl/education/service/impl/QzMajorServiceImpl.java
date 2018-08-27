package com.ctrl.education.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzMajorMapper;
import com.ctrl.education.dao.QzTeacherMapper;
import com.ctrl.education.model.QzMajor;
import com.ctrl.education.model.QzTeacher;
import com.ctrl.education.model.SysDict;
import com.ctrl.education.service.IQzMajorService;
import com.ctrl.education.service.IQzTeacherService;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 专业表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-07-20
 */
@Service
public class QzMajorServiceImpl extends ServiceImpl<QzMajorMapper, QzMajor> implements IQzMajorService {

    @Override
    public Result selectMajor() {
        List<QzMajor> qzMajorList = this.baseMapper.selectMajor();
        if (qzMajorList.size() > 0) {
            return Result.ok().put("msg", SystemConstant.QUERY_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", qzMajorList);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
    }

    @Override
    public Result getMajorById(String id) {
        QzMajor qzMajor = this.baseMapper.getMajorById(id);
        if (qzMajor != null) {
            return Result.ok().put("msg", SystemConstant.QUERY_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", qzMajor);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
    }
}
