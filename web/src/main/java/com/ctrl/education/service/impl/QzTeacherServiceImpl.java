package com.ctrl.education.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzTeacher;
import com.ctrl.education.dao.QzTeacherMapper;
import com.ctrl.education.model.SysDict;
import com.ctrl.education.model.SysLog;
import com.ctrl.education.service.IQzTeacherService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
 * 教师表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-07-20
 */
@Service
public class QzTeacherServiceImpl extends ServiceImpl<QzTeacherMapper, QzTeacher> implements IQzTeacherService {
    @Override
    public Result getList(Map<String, Object> params) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result add(QzTeacher qzTeacher) {
        qzTeacher.setSysUserId(ShiroKit.getUser().getId());
        qzTeacher.setState(1);
        qzTeacher.setSysCode(RandomUtil.randomString(4));
        int count = this.baseMapper.addTeacher(qzTeacher);
        if (count < 1) {
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("code", SystemConstant.SUCCESS);
            map.put("msg", SystemConstant.ADD_SUCCESS);
            return Result.ok(map);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result modify(QzTeacher qzTeacher) {
        int count = this.baseMapper.modifyTeacher(qzTeacher);
        if (count < 1) {
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
        }
        return Result.ok(SystemConstant.QUERY_SUCCESS);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result remove(String id) {
        Integer count = this.baseMapper.removeTeacher(id);
        if (count == 1) {
            return Result.ok().put("code", SystemConstant.SUCCESS).put("msg", SystemConstant.DELETE_SUCCESS);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.DELETE_FAILURE);
    }

    /**
     * 根据ID获取教师信息
     *
     * @param id
     * @return
     */
    @Override
    public Result getInfo(String id) {
        QzTeacher qzTeacher = this.baseMapper.getTeacherById(id);
        if (qzTeacher != null && !qzTeacher.equals("")) {
            return Result.ok().put("code", SystemConstant.SUCCESS).put("msg", SystemConstant.QUERY_SUCCESS)
                    .put("result", qzTeacher);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
    }

    /**
     * 教师列表
     *
     * @param params
     * @return
     */
    @Override
    public Result teacherList(Map<String, Object> params) {
        String name = (String) params.get("name");
        Page<QzTeacher> page = this.selectPage(
                new Query<QzTeacher>(params).getPage(),
                new EntityWrapper<QzTeacher>()
                        .like(StringUtils.isNotBlank(name), "name", name));
        return new PageUtils(page).toLayTableResult();

    }

    /**
     * 教师等级下拉
     *
     * @return
     */
    @Override
    public Result selectTeacher() {
        List<SysDict> sysDicts = this.baseMapper.selectTeacher();
        if (sysDicts == null && sysDicts.size() == 0) {
            return new Result().put("code", SystemConstant.ERROR_CODE).put("msg", SystemConstant.QUERY_FAILURE);
        } else {
            return new Result().put("code", SystemConstant.SUCCESS).put("msg", SystemConstant.QUERY_SUCCESS)
                    .put("result", sysDicts);
        }
    }

    @Override
    public Result selectReview(){
        List<QzTeacher> qzTeacherList = this.baseMapper.selectReview();
        if (qzTeacherList.size() > 0){
            return Result.ok().put("msg",SystemConstant.QUERY_SUCCESS).put("code",SystemConstant.SUCCESS).put("result",qzTeacherList);
        }
        return Result.error(SystemConstant.ERROR_CODE,SystemConstant.QUERY_FAILURE);
    }
}
