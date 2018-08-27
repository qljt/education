package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * com.ctrl.education.model
 * 培训任务列表表
 *
 * @author liyang
 * @name QzTrain
 * @description
 * @date 2018-08-21 9:21
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_train")
public class QzTrain extends Model<QzTrain> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 培训方案名称
     */
    @TableField(value = "tr_name")
    private String trName;
    /**
     * 培训方案编码
     */
    @TableField(value = "code")
    private String code;
    /**
     * 开始时间
     */
    @TableField(value = "start_time")
    private String startTime;
    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    private String endTime;
    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private String createtime;
    /**
     * 最后一次编辑时间
     */
    @TableField(value = "edit_time")
    private String editTime;
    /**
     * 编辑名称
     */
    @TableField(value = "editor")
    private String editor;
    /**
     * 状态 0删除 1正常 2禁用
     */
    @TableField(value = "state")
    private Integer state;
    /**
     * 培训类型 0考试 1课程
     */
    @TableField(value = "type")
    private Integer type;
    /**
     * 可获得积分
     */
    @TableField(value = "score")
    private Integer score;
    /**
     * 培训方案简介
     */
    @TableField(value = "content")
    private String content;
    /**
     * 部门ID数组，逗号隔开
     */
    @TableField(value = "depart_ids")
    private String departIds;
    /**
     * 用户ID数组，逗号隔开
     */
    @TableField(value = "users_ids")
    private String usersIds;
    /**
     * 岗位ID数组，逗号隔开
     */
    @TableField(value = "position_ids")
    private String positionIds;
    /**
     * 是否考试必须通过 0否 1是（类型为考试时使用）
     */
    @TableField(value = "is_pass")
    private Integer isPass;
    /**
     * 系统编码
     */
    @TableField(value = "sys_code")
    private String sysCode;
    /**
     * 培训状态 0未开始 1已开始 2已结束
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 证书模板ID
     */
    @TableField(value = "cer_template_id")
    private String cerTemplateId;
    /**
     * 对外发布时间
     */
    @TableField(value = "put_time")
    private String putTime;
    /**
     * 最多报名人数
     */
    @TableField(value = "max_sign")
    private Integer maxSign;
    /**
     * 已经报名人数
     */
    @TableField(value = "already_sign")
    private Integer alreadySign;
    /**
     * 编辑人员ID
     */
    @TableField(value = "sys_user_id")
    private String sysUserId;

    public String getId() {
        return id;
    }

    public QzTrain setId(String id) {
        this.id = id;
        return this;
    }

    public String getTrName() {
        return trName;
    }

    public QzTrain setTrName(String trName) {
        this.trName = trName;
        return this;
    }

    public String getCode() {
        return code;
    }

    public QzTrain setCode(String code) {
        this.code = code;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public QzTrain setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public QzTrain setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public QzTrain setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public String getEditTime() {
        return editTime;
    }

    public QzTrain setEditTime(String editTime) {
        this.editTime = editTime;
        return this;
    }

    public String getEditor() {
        return editor;
    }

    public QzTrain setEditor(String editor) {
        this.editor = editor;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public QzTrain setState(Integer state) {
        this.state = state;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public QzTrain setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public QzTrain setScore(Integer score) {
        this.score = score;
        return this;
    }

    public String getContent() {
        return content;
    }

    public QzTrain setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDepartIds() {
        return departIds;
    }

    public QzTrain setDepartIds(String departIds) {
        this.departIds = departIds;
        return this;
    }

    public String getUsersIds() {
        return usersIds;
    }

    public QzTrain setUsersIds(String usersIds) {
        this.usersIds = usersIds;
        return this;
    }

    public String getPositionIds() {
        return positionIds;
    }

    public QzTrain setPositionIds(String positionIds) {
        this.positionIds = positionIds;
        return this;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public QzTrain setIsPass(Integer isPass) {
        this.isPass = isPass;
        return this;
    }

    public String getSysCode() {
        return sysCode;
    }

    public QzTrain setSysCode(String sysCode) {
        this.sysCode = sysCode;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public QzTrain setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getCerTemplateId() {
        return cerTemplateId;
    }

    public QzTrain setCerTemplateId(String cerTemplateId) {
        this.cerTemplateId = cerTemplateId;
        return this;
    }

    public String getPutTime() {
        return putTime;
    }

    public QzTrain setPutTime(String putTime) {
        this.putTime = putTime;
        return this;
    }

    public Integer getMaxSign() {
        return maxSign;
    }

    public QzTrain setMaxSign(Integer maxSign) {
        this.maxSign = maxSign;
        return this;
    }

    public Integer getAlreadySign() {
        return alreadySign;
    }

    public QzTrain setAlreadySign(Integer alreadySign) {
        this.alreadySign = alreadySign;
        return this;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public QzTrain setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzTrain{" +
                "id='" + id + '\'' +
                ", trName='" + trName + '\'' +
                ", code='" + code + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", createtime='" + createtime + '\'' +
                ", editTime='" + editTime + '\'' +
                ", editor='" + editor + '\'' +
                ", state=" + state +
                ", type=" + type +
                ", score=" + score +
                ", content='" + content + '\'' +
                ", departIds='" + departIds + '\'' +
                ", usersIds='" + usersIds + '\'' +
                ", positionIds='" + positionIds + '\'' +
                ", isPass=" + isPass +
                ", sysCode='" + sysCode + '\'' +
                ", status=" + status +
                ", cerTemplateId='" + cerTemplateId + '\'' +
                ", putTime='" + putTime + '\'' +
                ", maxSign=" + maxSign +
                ", alreadySign=" + alreadySign +
                ", sysUserId='" + sysUserId + '\'' +
                '}';
    }
}
