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
 * @name QzCouChapterSection
 * @description
 * @date 2018-08-03 19:02
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_cou_chapter_section")
public class QzCouChapterSection extends Model<QzCouChapterSection> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 章ID（FFFFFF默认为没有章）
     */
    @TableField("chapter_id")
    private String chapterId;
    /**
     * 节名称
     */
    @TableField("sec_name")
    private String secName;
    /**
     * 时长
     */
    @TableField("length_time")
    private String lengthTime;
    /**
     * 排序值
     */
    @TableField("sort")
    private Integer sort;
    /**
     * 课程ID
     */
    @TableField("cou_id")
    private String couId;
    /**
     * 状态0删除1正常 2禁用
     */
    private Integer state;
    /**
     * 课件类型0文档 1视频 2三分屏3网络资源
     */
    @TableField("type")
    private Integer type;
    /**
     * 文件地址
     */
    @TableField("file_url")
    private String fileUrl;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;
    /**
     * 编辑人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;

    public String getId() {
        return id;
    }

    public QzCouChapterSection setId(String id) {
        this.id = id;
        return this;
    }

    public String getChapterId() {
        return chapterId;
    }

    public QzCouChapterSection setChapterId(String chapterId) {
        this.chapterId = chapterId;
        return this;
    }

    public String getSecName() {
        return secName;
    }

    public QzCouChapterSection setSecName(String secName) {
        this.secName = secName;
        return this;
    }

    public String getLengthTime() {
        return lengthTime;
    }

    public QzCouChapterSection setLengthTime(String lengthTime) {
        this.lengthTime = lengthTime;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public QzCouChapterSection setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getCouId() {
        return couId;
    }

    public QzCouChapterSection setCouId(String couId) {
        this.couId = couId;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public QzCouChapterSection setState(Integer state) {
        this.state = state;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public QzCouChapterSection setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public QzCouChapterSection setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
        return this;
    }

    public String getSysCode() {
        return sysCode;
    }

    public QzCouChapterSection setSysCode(String sysCode) {
        this.sysCode = sysCode;
        return this;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public QzCouChapterSection setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzCouChapterSection{" +
                "id='" + id + '\'' +
                ", chapterId='" + chapterId + '\'' +
                ", secName='" + secName + '\'' +
                ", lengthTime='" + lengthTime + '\'' +
                ", sort=" + sort +
                ", couId='" + couId + '\'' +
                ", state=" + state +
                ", type=" + type +
                ", fileUrl='" + fileUrl + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", sysUserId='" + sysUserId + '\'' +
                '}';
    }
}
