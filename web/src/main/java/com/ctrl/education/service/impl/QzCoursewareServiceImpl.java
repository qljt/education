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
import com.ctrl.education.dao.QzCoursewareMapper;
import com.ctrl.education.model.*;
import com.ctrl.education.service.IQzCoursewareService;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzCoursewareServiceImpl extends ServiceImpl<QzCoursewareMapper, QzCourseware> implements IQzCoursewareService {
    /**
     * 获取课程列表
     *
     * @param map
     * @return
     */
    @Override
    public Result list(Map<String, Object> map) {
        String id = (String) map.get("id");
        String couName = (String) map.get("couName");
        String state = (String) map.get("state");
        String startTime = (String) map.get("startTime");
        String endTime = (String) map.get("endTime");
        // 获取总条数
        List<Map<String, Object>> list = baseMapper.getList(map);
        Page<QzCourseware> page = this.selectPage(
                new Query<QzCourseware>(map).getPage(),
                new EntityWrapper<QzCourseware>()
                        .like(StringUtils.isNotBlank(couName), "cou_name", couName)
                        .like(StringUtils.isNotBlank(id), "id", id)
                        .eq(StringUtils.isNotEmpty(state), "state", state)
                        .ne("state", 0)
                        .between(StringUtils.isNotBlank(startTime), "createtime", startTime, endTime)
                        .orderBy("createtime", true));
        Integer totalCount = Integer.parseInt(String.valueOf(page.getTotal()));
        return new Result().ok()
                .put("total", totalCount)
                .put("rows", list);
    }

    /**
     * 新增课程
     *
     * @param qzCourseware
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addCourseware(QzCourseware qzCourseware) {
        qzCourseware.setCreatetime(DateUtil.now());
        qzCourseware.setSysUserId(ShiroKit.getUser().getId());
        qzCourseware.setSysCode(RandomUtil.randomString(4));
        qzCourseware.setState(1);
        int count = this.baseMapper.addCourseware(qzCourseware);
        if (count > 0) {
            String id = qzCourseware.getId();
            if (!StringUtils.isEmpty(id)) {
                return returnValue(id, SystemConstant.ADD_SUCCESS, SystemConstant.ADD_SUCCESS, SystemConstant.SUCCESS);
            }
        }
        return Result.error(SystemConstant.ADD_FAILURE);
    }

    /**
     * 修改课程
     *
     * @param qzCourseware
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result modifyCourseware(QzCourseware qzCourseware) {
        if (StringUtils.isEmpty(qzCourseware.getId()) || qzCourseware.getId() == null || qzCourseware.getId().equals("")) {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
        int count = this.baseMapper.updateById(qzCourseware);
        if (count > 0) {
            String id = qzCourseware.getId();
            if (!StringUtils.isEmpty(id)) {
                return returnValue(id, SystemConstant.ADD_SUCCESS, SystemConstant.ADD_SUCCESS, SystemConstant.SUCCESS);
            }
        }
        return Result.error(SystemConstant.ADD_FAILURE);
    }

    /**
     * 删除课程
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result remove(String id) {
        int count = this.baseMapper.remove(id);
        if (count > 0) {
            return Result.ok().put("msg", SystemConstant.DELETE_SUCCESS).put("code", SystemConstant.SUCCESS);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.DELETE_FAILURE);
    }

    /**
     * 所有讲师信息
     *
     * @return
     */
    @Override
    public Result allTeacher() {
        List<QzTeacher> qzTeachers = this.baseMapper.allTeacher();
        return returnValue(qzTeachers, SystemConstant.QUERY_FAILURE, SystemConstant.QUERY_SUCCESS, SystemConstant.SUCCESS);
    }

    /**
     * 所有课程分类
     *
     * @return
     */
    @Override
    public Result selectClassify() {
        List<QzTypeDictionary> qzTypeDictionaries = this.baseMapper.selectClassify();
        return returnValue(qzTypeDictionaries, SystemConstant.QUERY_FAILURE, SystemConstant.QUERY_SUCCESS, SystemConstant.SUCCESS);
    }

    @Override
    public Result selectDept() {
        List<SysOffice> sysOffices = this.baseMapper.selectDept();
        return returnValue(sysOffices, SystemConstant.QUERY_FAILURE, SystemConstant.QUERY_SUCCESS, SystemConstant.SUCCESS);
    }

    @Override
    public Result selectUser(String departIds) {
        List<SysUser> sysUsers = this.baseMapper.selectUser(departIds);
        return returnValue(sysUsers, SystemConstant.QUERY_FAILURE, SystemConstant.QUERY_SUCCESS, SystemConstant.SUCCESS);
    }

    public Result returnValue(Object object, String failureMsg, String successMsg, Integer code) {
        Map<String, Object> map = new HashMap<>();
        if (object == null || object.equals("")) {
            return Result.error(failureMsg);
        } else {
            map.put("code", code);
            map.put("msg", successMsg);
            map.put("result", object);
            return Result.ok(map);
        }
    }

    @Override
    public Result getCourwareById(String id) {
        QzCourseware qzCourseware = this.baseMapper.getCourwareById(id);
        if (qzCourseware != null) {
            return Result.ok().put("msg", SystemConstant.QUERY_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", qzCourseware);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
    }

    @Override
    public Result modify(QzCourseware qzCourseware) {
        int count = this.baseMapper.modify(qzCourseware);
        if (count > 0) {
            return Result.ok().put("msg", SystemConstant.UPDATE_SUCCESS).put("code", SystemConstant.SUCCESS);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.UPDATE_FAILURE);
    }
}
