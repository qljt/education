package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.AlohaDateUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzInformation;
import com.ctrl.education.dao.QzInformationMapper;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.service.IQzInformationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 动态资讯 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
@Service
public class QzInformationServiceImpl extends ServiceImpl<QzInformationMapper, QzInformation> implements IQzInformationService {
    @Override
    public Result getList(Map<String, Object> param) {
        String title = (String) param.get("title");
        String state = (String) param.get("state");
        String infoTypeId = (String) param.get("infoTypeId");
        String startTime = (String) param.get("startTime");
        String endTime = (String) param.get("endTime");
        List<Map<String, Object>> list = baseMapper.getList(param);
        Page<QzInformation> page = this.selectPage(
                new Query<QzInformation>(param).getPage(),
                new EntityWrapper<QzInformation>()
                        .eq(StringUtils.isNotEmpty(state), "state", state)
                        .eq(StringUtils.isNotEmpty(infoTypeId), "type_id", infoTypeId)
                        .like(StringUtils.isNotEmpty(title), "title", title)
                        .between(StringUtils.isNotBlank(endTime), "createtime", startTime, endTime)
                        .orderBy("createtime", true)
        );
        Integer totalCount = page.getRecords().size();
        return new Result().ok()
                .put("total", totalCount)
                .put("rows", list);
    }

    @Override
    public Result save(QzInformation qzInformation) {
        String createTime = AlohaDateUtils.getDay();
        qzInformation.setCreatetime(createTime);
        boolean flag = this.insert(qzInformation);
        if (flag) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    public Result modify(QzInformation qzInformation) {
        if (StringUtils.isEmpty(qzInformation.getId())) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        String createTime = AlohaDateUtils.getDay();
        qzInformation.setCreatetime(createTime);
        boolean flag = this.updateById(qzInformation);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override
    public Result getInfo(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        Map<String, Object> map = baseMapper.getInfo(id);
        return Result.ok().put(SystemConstant.RESULT_KEY, map);
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result remove(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        int count = baseMapper.remove(id);
        if (count > 0) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public Result putInfo(QzInformation qzInformation) {
        String putTime = AlohaDateUtils.getDay();
        qzInformation.setPutTime(putTime);
        qzInformation.setState(4);
        boolean flag = this.updateById(qzInformation);
        if (flag) {
            return Result.ok(SystemConstant.SEND_SUCCESS);
        } else {
            return Result.error(SystemConstant.SEND_FAILURE);
        }
    }
}
