package com.ctrl.education.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzCouChapterMapper;
import com.ctrl.education.dao.QzPaperMapper;
import com.ctrl.education.model.*;
import com.ctrl.education.service.IQzCouChapterService;
import com.ctrl.education.service.IQzPaperPartService;
import com.ctrl.education.service.IQzPaperService;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 试卷/问卷调查表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzPaperServiceImpl extends ServiceImpl<QzPaperMapper, QzPaper> implements IQzPaperService {
    /**
     * 问卷调查列表
     *
     * @param params
     * @return
     */
    @Override
    public Result list(Map<String, Object> params) {
        String name = (String) params.get("name");
        Page<QzPaper> page = this.selectPage(
                new Query<QzPaper>(params).getPage(),
                new EntityWrapper<QzPaper>()
                        .like(StringUtils.isNotBlank(name), "name", name)
                        .eq(true, "state", 1)
        );
        return new PageUtils(page).toLayTableResult();
    }

    @Override
    public Result add(QzPaper qzPaper) {
        qzPaper.setType(1);
        qzPaper.setCreatetime(DateUtil.now());
        qzPaper.setSysUserId(ShiroKit.getUser().getId());
        qzPaper.setState(1);
        if (qzPaper.getId() == null) {
            int count = this.baseMapper.insert(qzPaper);
            String id = qzPaper.getId();
            if (count > 0) {
                Map<String, Object> map = new HashMap<>();
                return Result.ok().put("msg", SystemConstant.ADD_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", id);
            }
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
    }

    @Override
    public Result deleteById(String id) {
        int count = this.baseMapper.remove(id);
        if (count > 0) {
            return Result.ok().put("msg", SystemConstant.DELETE_SUCCESS).put("code", SystemConstant.SUCCESS);
        } else {
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public Result selectPaper(){
        List<QzPaper> paperList = this.baseMapper.selectPaper();
        if (paperList.size() != 0){
            return Result.ok().put("msg",SystemConstant.QUERY_SUCCESS).put("code",SystemConstant.SUCCESS).put("result",paperList);
        }
        return Result.error(SystemConstant.ERROR_CODE,SystemConstant.QUERY_FAILURE);
    }
}
