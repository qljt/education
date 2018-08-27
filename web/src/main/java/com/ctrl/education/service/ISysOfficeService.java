package com.ctrl.education.service;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysOffice;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 机构表 服务类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
public interface ISysOfficeService extends IService<SysOffice> {

    Result officeTree();

    Result save(SysOffice sysOffice);

    Result modify(SysOffice sysOffice);

    Result remove(String id);

    List<Map<String, Object>> getList(Map<String, Object> map);

    Map<String, Object> selectOfficeById(String id);

    Result deptTree();

    Result officeSelect();

    Result selectOfficeByType(Integer type);

    Result getDeptByCode(String code);
}
