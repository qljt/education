package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程表 Mapper 接口
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface QzCoursewareMapper extends BaseMapper<QzCourseware> {

    int addCourseware(QzCourseware qzCourseware);

    List<QzTeacher> allTeacher();

    List<QzTypeDictionary> selectClassify();

    List<SysOffice> selectDept();

    List<SysUser> selectUser(@Param("departIds") String departIds);

    List<Map<String, Object>> getList(Map<String, Object> map);

    int remove(String id);

    QzCourseware getCourwareById(String id);

    int modify(QzCourseware qzCourseware);
}
