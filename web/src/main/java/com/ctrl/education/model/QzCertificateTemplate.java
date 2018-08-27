package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * com.ctrl.education.model
 * 培训证书模板表
 *
 * @author liyang
 * @name QzCertificateTemplate
 * @description
 * @date 2018-08-22 10:03
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
public class QzCertificateTemplate extends Model<QzCertificateTemplate> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 证书模板名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 模板地址
     */
    @TableField(value = "tem_path")
    private String temPath;
    /**
     * 排序值
     */
    @TableField(value = "sort")
    private Integer sort;
    /**
     * 系统编码
     */
    @TableField(value = "sys_code")
    private String sysCode;
    /**
     * 状态 0删除1正常 2禁用
     */
    @TableField(value = "state")
    private Integer state;
    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private String createtime;
    /**
     * 编辑人员ID
     */
    @TableField(value = "sys_user_id")
    private String sysUserId;

    public String getId() {
        return id;
    }

    public QzCertificateTemplate setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public QzCertificateTemplate setName(String name) {
        this.name = name;
        return this;
    }

    public String getTemPath() {
        return temPath;
    }

    public QzCertificateTemplate setTemPath(String temPath) {
        this.temPath = temPath;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public QzCertificateTemplate setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getSysCode() {
        return sysCode;
    }

    public QzCertificateTemplate setSysCode(String sysCode) {
        this.sysCode = sysCode;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public QzCertificateTemplate setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public QzCertificateTemplate setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public QzCertificateTemplate setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzCertificateTemplate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", temPath='" + temPath + '\'' +
                ", sort=" + sort +
                ", sysCode='" + sysCode + '\'' +
                ", state=" + state +
                ", createtime='" + createtime + '\'' +
                ", sysUserId='" + sysUserId + '\'' +
                '}';
    }
}
