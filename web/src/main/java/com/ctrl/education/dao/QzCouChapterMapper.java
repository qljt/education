package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程表 Mapper 接口
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface QzCouChapterMapper extends BaseMapper<QzCouChapter> {

    int addChapter(QzCouChapter qzCouChapter);

}
