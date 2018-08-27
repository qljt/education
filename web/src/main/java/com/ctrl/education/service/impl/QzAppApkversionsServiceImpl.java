package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.AlohaDateUtils;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzAppApkversions;
import com.ctrl.education.dao.QzAppApkversionsMapper;
import com.ctrl.education.model.QzAppFeedback;
import com.ctrl.education.service.IQzAppApkversionsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@Service
public class QzAppApkversionsServiceImpl extends ServiceImpl<QzAppApkversionsMapper, QzAppApkversions> implements IQzAppApkversionsService {

    @Override
    public Result getList(Map<String, Object> map) {
        String apkname = (String) map.get("apkname");
        String type = (String) map.get("type");
        String startTime = (String)map.get("startTime");
        String endTime = (String)map.get("endTime");
        Page<QzAppApkversions> page = this.selectPage(
                new Query<QzAppApkversions>(map).getPage(),
                new EntityWrapper<QzAppApkversions>()
                        .like(StringUtils.isNotBlank(apkname), "apkname", apkname)
                        .orderBy("updatetime",true));
        return new PageUtils(page).toLayTableResult();
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(QzAppApkversions qzAppApkversions) {
        String updateTime = AlohaDateUtils.getDay();
        qzAppApkversions.setUpdatetime(updateTime);
        boolean flag = this.insert(qzAppApkversions);
       if(flag){
           if(qzAppApkversions.getIsnew().equalsIgnoreCase("1")){
             this.updateIsNotNew(qzAppApkversions);
           }
           return Result.ok(SystemConstant.ADD_SUCCESS);
       }else {
           return Result.error(SystemConstant.ADD_FAILURE);
       }
    }

    @Override
    public Result modify(QzAppApkversions qzAppApkversions) {
        String updateTime = AlohaDateUtils.getDay();
        qzAppApkversions.setUpdatetime(updateTime);
        boolean flag = updateById(qzAppApkversions);
        if(flag){
            if(qzAppApkversions.getIsnew().equalsIgnoreCase("1")){
                this.updateIsNotNew(qzAppApkversions);
            }
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        }else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override
    public Result getInfo(String id) {
        if(StringUtils.isEmpty(id)){
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        QzAppApkversions qzAppApkversions = this.selectById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY,qzAppApkversions);
    }
    @Transactional(
            rollbackFor = {Exception.class}
    )

    @Override
    public Result remove(String id) {
        if(StringUtils.isEmpty(id)){
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        boolean flag = this.deleteById(id);
        if(flag){
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        }else{;
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    /**
     * 更新其他记录为不是最新
     * @param qzAppApkversions
     */
    private void updateIsNotNew(QzAppApkversions qzAppApkversions){
        Map<String,Object> map = new HashMap<>();
        map.put("id",qzAppApkversions.getId());
        map.put("type",qzAppApkversions.getType());
        baseMapper.updateIsNotNew(map);
    }
}
