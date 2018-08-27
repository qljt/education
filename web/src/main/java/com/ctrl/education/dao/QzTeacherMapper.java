package com.ctrl.education.dao;

import com.ctrl.education.model.QzTeacher;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.SysDict;

import java.util.List;

/**
 * <p>
 * 教师表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-07-20
 */
public interface QzTeacherMapper extends BaseMapper<QzTeacher> {

    List<QzTeacher> teacherList();

    int addTeacher(QzTeacher qzTeacher);

    List<SysDict> selectTeacher();

    QzTeacher getTeacherById(String id);

    int modifyTeacher(QzTeacher qzTeacher);

    int removeTeacher(String id);

    List<QzTeacher> selectReview();
}
