package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzTeacher;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 教师表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-07-20
 */
public interface IQzTeacherService extends IService<QzTeacher> {

    Result getList(Map<String,Object> params);

    Result add(QzTeacher qzTeacher);

    Result modify(QzTeacher qzTeacher);

    Result remove(String id);

    Result getInfo(String id);

    Result teacherList(Map<String,Object> params);

    Result selectTeacher();

    Result selectReview();
}
