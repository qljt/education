package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzCourseware;

import java.util.Map;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface IQzCoursewareService extends IService<QzCourseware> {

    Result list(Map<String, Object> map);

    Result addCourseware(QzCourseware qzCourseware);

    Result modifyCourseware(QzCourseware qzCourseware);

    Result allTeacher();

    Result selectClassify();

    Result selectDept();

    Result selectUser(String departIds);

    Result remove(String id);

    Result getCourwareById(String id);

    Result modify(QzCourseware qzCourseware);
}
