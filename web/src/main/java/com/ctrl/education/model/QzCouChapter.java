package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * com.ctrl.education.model
 *
 * @author liyang
 * @name QzCouChapter
 * @description
 * @date 2018-08-03 18:44
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_cou_chapter")
public class QzCouChapter extends Model<QzCouChapter> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 章名称
     */
    @TableField("cou_name")
    private String chName;
    /**
     * 排序值
     */
    @TableField("sort")
    private Integer sort;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;
    /**
     * 课程ID
     */
    @TableField("cou_id")
    private String couId;
    /**
     * 创建时间
     */
    @TableField("createtime")
    private String createtime;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state;
    /**
     * 编辑人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;

    public String getId() {
        return id;
    }

    public QzCouChapter setId(String id) {
        this.id = id;
        return this;
    }

    public String getChName() {
        return chName;
    }

    public QzCouChapter setChName(String chName) {
        this.chName = chName;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public QzCouChapter setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getSysCode() {
        return sysCode;
    }

    public QzCouChapter setSysCode(String sysCode) {
        this.sysCode = sysCode;
        return this;
    }

    public String getCouId() {
        return couId;
    }

    public QzCouChapter setCouId(String couId) {
        this.couId = couId;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public QzCouChapter setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public QzCouChapter setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public QzCouChapter setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzCouChapter{" +
                "id='" + id + '\'' +
                ", chName='" + chName + '\'' +
                ", sort=" + sort +
                ", sysCode='" + sysCode + '\'' +
                ", couId='" + couId + '\'' +
                ", createtime='" + createtime + '\'' +
                ", state=" + state +
                ", sysUserId='" + sysUserId + '\'' +
                '}';
    }
}
