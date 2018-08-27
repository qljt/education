package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.QzPaper;
import com.ctrl.education.model.QzPaperPart;

import java.util.List;

/**
 * <p>
 * 试题区块表 Mapper 接口
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
public interface QzPaperPartMapper extends BaseMapper<QzPaperPart> {
    List<QzPaperPart> paperPartInfo(QzPaperPart qzPaperPart);
}
