package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * com.ctrl.education.model
 * 试卷/问卷调查表
 * @author liyang_1
 * @name QzPaper
 * @description
 * @date 2018-08-06 18:42
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_paper")
public class QzPaper extends Model<QzPaper> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 专业ID
     */
    @TableField("major_id")
    private String majorId;
    /**
     * 题库ID
     */
    @TableField("question_id")
    private String questionId;
    /**
     * 类别 0考试题库 1调查问卷
     */
    @TableField("type")
    private Integer type;
    /**
     * 名称
     */
    @TableField("name")
    private String name;
    /**
     * 简称
     */
    @TableField("name_jc")
    private String nameJc;
    /**
     * 建议考试时间(秒)
     */
    @TableField("total_time")
    private Integer totalTime;
    /**
     * 满分值
     */
    @TableField("total_score")
    private Double totalScore;
    /**
     * 建议及格分数
     */
    @TableField("pass_socre")
    private Double passSocre;
    /**
     * 平均难度
     */
    @TableField("avg_difficulty")
    private Double avgDifficulty;
    /**
     * 平均区分度
     */
    @TableField("avg_differen")
    private Double avgDifferen;
    /**
     * 知识点
     */
    @TableField("knowlcode_id")
    private String knowlcodeId;
    /**
     * 试卷用途
     */
    @TableField("paper_userful")
    private String paperUserful;
    /**
     * 固定卷还是随机卷 0固定卷 1随机卷
     */
    @TableField("sls_randowm")
    private Integer slsRandowm;
    /**
     * 题型数量
     */
    @TableField("question_type_count")
    private Integer questionTypeCount;
    /**
     * 题目总数
     */
    @TableField("question_count")
    private Integer questionCount;
    /**
     * 状态 0删除 1正常
     */
    private Integer state;
    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
    /**
     * 操作人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 最后更新时间
     */
    @TableField("last_update_time")
    private String lastUpdateTime;
    /**
     *录入人机构ID
     */
    @TableField("office_id")
    private String officeId;
    /**
     * 编辑权限 0 私人 1本层机构 2本角色人员
     */
    @TableField("edit_permissions")
    private Integer editPermissions;
    /**
     * 共享给管理员的范围 0本级机构所有管理员 1本级及下级所有管理员、所有机构管理员2本级及下级本角色管理员3所有机构本角色管理员
     */
    @TableField("share_admin")
    private Integer shareAdmin;
    /**
     * 学员使用范围—是否指派学员可见范围 0或空不指派，1为指派，若为指派，则需要维护指派的范围，2对内外所人员公开，
     * 3、对内所有机构人员公开，若不指派默认均不可见
     */
    @TableField("use_student")
    private Integer useStudent;
    /**
     * 最后使用时间
     */
    @TableField("last_use_time")
    private String lastUseTime;
    /**
     * 抽题题库ID数组,逗号隔开
     */
    @TableField("question_ids")
    private String questionIds;
    /**
     * 批次信息
     */
    @TableField("batch")
    private String batch;
    /**
     * 发布时间
     */
    @TableField("start_time")
    private String startTime;
    /**
     * 截止时间
     */
    @TableField("end_time")
    private String endTime;

    public String getId() {
        return id;
    }

    public QzPaper setId(String id) {
        this.id = id;
        return this;
    }

    public String getMajorId() {
        return majorId;
    }

    public QzPaper setMajorId(String majorId) {
        this.majorId = majorId;
        return this;
    }

    public String getQuestionId() {
        return questionId;
    }

    public QzPaper setQuestionId(String questionId) {
        this.questionId = questionId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public QzPaper setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public QzPaper setName(String name) {
        this.name = name;
        return this;
    }

    public String getNameJc() {
        return nameJc;
    }

    public QzPaper setNameJc(String nameJc) {
        this.nameJc = nameJc;
        return this;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public QzPaper setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
        return this;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public QzPaper setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
        return this;
    }

    public Double getPassSocre() {
        return passSocre;
    }

    public QzPaper setPassSocre(Double passSocre) {
        this.passSocre = passSocre;
        return this;
    }

    public Double getAvgDifficulty() {
        return avgDifficulty;
    }

    public QzPaper setAvgDifficulty(Double avgDifficulty) {
        this.avgDifficulty = avgDifficulty;
        return this;
    }

    public Double getAvgDifferen() {
        return avgDifferen;
    }

    public QzPaper setAvgDifferen(Double avgDifferen) {
        this.avgDifferen = avgDifferen;
        return this;
    }

    public String getKnowlcodeId() {
        return knowlcodeId;
    }

    public QzPaper setKnowlcodeId(String knowlcodeId) {
        this.knowlcodeId = knowlcodeId;
        return this;
    }

    public String getPaperUserful() {
        return paperUserful;
    }

    public QzPaper setPaperUserful(String paperUserful) {
        this.paperUserful = paperUserful;
        return this;
    }

    public Integer getSlsRandowm() {
        return slsRandowm;
    }

    public QzPaper setSlsRandowm(Integer slsRandowm) {
        this.slsRandowm = slsRandowm;
        return this;
    }

    public Integer getQuestionTypeCount() {
        return questionTypeCount;
    }

    public QzPaper setQuestionTypeCount(Integer questionTypeCount) {
        this.questionTypeCount = questionTypeCount;
        return this;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public QzPaper setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public QzPaper setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public QzPaper setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public QzPaper setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public QzPaper setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public QzPaper setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public String getOfficeId() {
        return officeId;
    }

    public QzPaper setOfficeId(String officeId) {
        this.officeId = officeId;
        return this;
    }

    public Integer getEditPermissions() {
        return editPermissions;
    }

    public QzPaper setEditPermissions(Integer editPermissions) {
        this.editPermissions = editPermissions;
        return this;
    }

    public Integer getShareAdmin() {
        return shareAdmin;
    }

    public QzPaper setShareAdmin(Integer shareAdmin) {
        this.shareAdmin = shareAdmin;
        return this;
    }

    public Integer getUseStudent() {
        return useStudent;
    }

    public QzPaper setUseStudent(Integer useStudent) {
        this.useStudent = useStudent;
        return this;
    }

    public String getLastUseTime() {
        return lastUseTime;
    }

    public QzPaper setLastUseTime(String lastUseTime) {
        this.lastUseTime = lastUseTime;
        return this;
    }

    public String getQuestionIds() {
        return questionIds;
    }

    public QzPaper setQuestionIds(String questionIds) {
        this.questionIds = questionIds;
        return this;
    }

    public String getBatch() {
        return batch;
    }

    public QzPaper setBatch(String batch) {
        this.batch = batch;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public QzPaper setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public QzPaper setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public String toString() {
        return "QzPaper{" +
                "id='" + id + '\'' +
                ", majorId='" + majorId + '\'' +
                ", questionId='" + questionId + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", nameJc='" + nameJc + '\'' +
                ", totalTime=" + totalTime +
                ", totalScore=" + totalScore +
                ", passSocre=" + passSocre +
                ", avgDifficulty=" + avgDifficulty +
                ", avgDifferen=" + avgDifferen +
                ", knowlcodeId='" + knowlcodeId + '\'' +
                ", paperUserful='" + paperUserful + '\'' +
                ", slsRandowm=" + slsRandowm +
                ", questionTypeCount=" + questionTypeCount +
                ", questionCount=" + questionCount +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", sysUserId='" + sysUserId + '\'' +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", createtime='" + createtime + '\'' +
                ", officeId='" + officeId + '\'' +
                ", editPermissions=" + editPermissions +
                ", shareAdmin=" + shareAdmin +
                ", useStudent=" + useStudent +
                ", lastUseTime='" + lastUseTime + '\'' +
                ", questionIds='" + questionIds + '\'' +
                ", batch='" + batch + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
