package com.ctrl.education.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.model.QzInformation;
import com.ctrl.education.model.QzInformationType;
import com.ctrl.education.dao.QzInformationTypeMapper;
import com.ctrl.education.service.IQzInformationTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资讯分类 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
@Service
public class QzInformationTypeServiceImpl extends ServiceImpl<QzInformationTypeMapper, QzInformationType> implements IQzInformationTypeService {
    /**
     * 如果为1则拼上顶级，否则不拼
     * @param param
     * @return
     */
    @Override
    public Result tree(String param) {
        List<ZTreeNode> tree = this.baseMapper.tree(param);
        if(param.equals("1")){
            tree.add(ZTreeNode.createParent());
        }
        return Result.ok().put(SystemConstant.RESULT_KEY, tree);
    }

    @Override
    public List<Map<String, Object>> getList(Map<String, Object> map) {
        String name = (String) map.get("name");
        List<Map<String, Object>> list = this.selectMaps(new EntityWrapper<QzInformationType>()
                .like(StringUtils.isNotBlank(name), "group_name", name)
                .ne("state","0"));

        return list;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(QzInformationType qzInformationType) {
        if(this.hasName("0",qzInformationType.getName())){
            return Result.error("该分类已经存在");
        }
        if (StringUtils.isEmpty(qzInformationType.getPid()) || qzInformationType.getPid().equals("0")) {
            qzInformationType.setPid("0");
        }
        boolean flag = this.insert(qzInformationType);
        if (flag) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result modify(QzInformationType qzInformationType) {
        if(this.hasName(qzInformationType.getId(),qzInformationType.getName())){
            return Result.error("该分类已经存在");
        }
        if (StringUtils.isEmpty(qzInformationType.getPid()) || qzInformationType.getPid().equals(0)) {
            qzInformationType.setPid("0");
        }
        boolean flag = this.updateById(qzInformationType);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result remove(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        List<Map<String, Object>> list = this.selectMaps(new EntityWrapper<QzInformationType>()
                .where("pid={0}", id));
        if (ToolUtils.isNotEmpty(list)) {
            return Result.error(SystemConstant.EXSIT_CHILD_MENU);
        }
        QzInformationType qzInformationType = new QzInformationType();
        qzInformationType.setId(id);
        qzInformationType.setState(0);
        Integer count = baseMapper.updateById(qzInformationType);
        if (count>0) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public Map<String, Object> selectQzInformationTypeById(String id) {
        Map<String, Object> map = baseMapper.selectQzInformationTypeById(id);
        return map;
    }

    /**
     * 判断分类名称是否存在
     *
     * @param name
     */
    private boolean hasName(String id ,String name) {
        int count = baseMapper.selectCount(
                new EntityWrapper<QzInformationType>()
                        .ne(ObjectUtil.isNotNull(id), "id", id)
                        .eq("name", name)
        );
        if (count >= 1) {
            return true;
        } else{
           return false;
       }
    }

    @Override
    public List<QzInformationType> getInformationTypeList() {
        List<QzInformationType> list = this.selectList(new EntityWrapper<QzInformationType>());
        return list;
    }
}
