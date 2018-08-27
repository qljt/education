package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * com.ctrl.education.model
 * 试题表
 *
 * @author liyang
 * @name QzTestQuestions
 * @description
 * @date 2018-08-14 16:06
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_test_questions")
public class QzTestQuestions extends Model<QzTestQuestions> {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 题库ID
     */
    @TableField(value = "bank_id")
    private String bankId;
    /**
     * 题目类型 0客观题 1主观题
     */
    @TableField(value = "question_class")
    private Integer questionClass;
    /**
     * 试题类型 1 单项选择题2 多项选择题3 是非题4 简答题5 问答题6 填空题7 综合题
     */
    @TableField(value = "question_type")
    private Integer questionType;
    /**
     * 难易度(字典表)
     */
    @TableField(value = "difficulty")
    private String difficulty;
    /**
     * 区分度
     */
    @TableField(value = "different")
    private String different;
    /**
     * 认知分类01识记 02综合应用型
     */
    @TableField(value = "cognize")
    private String cognize;
    /**
     * 知识点ID
     */
    @TableField(value = "knowlcode_id")
    private String knowlcodeId;
    /**
     * 答题时间(秒)
     */
    @TableField(value = "answertime")
    private Integer answertime;
    /**
     * 建议分数
     */
    @TableField(value = "score")
    private Double score;
    /**
     * 题干
     */
    @TableField(value = "question_title")
    private String questionTitle;
    /**
     * 选项个数
     */
    @TableField(value = "qnumber")
    private Integer qnumber;
    /**
     * 选项是否可以随机排序0否 1是
     */
    @TableField(value = "is_random")
    private Integer isRandom;
    /**
     * 正确答案个数
     */
    @TableField(value = "answer_qnumber")
    private Integer answerQnumber;
    /**
     * 主观答案
     */
    @TableField(value = "obj_answer")
    private String objAnswer;
    /**
     * 解析
     */
    @TableField(value = "question_solution")
    private String questionSolution;
    /**
     * 是否有子题目 0否 1是
     */
    @TableField(value = "is_have_child")
    private Integer isHaveChild;
    /**
     * 子题目数量
     */
    @TableField(value = "child_count")
    private Integer childCount;
    /**
     * 附件名称
     */
    @TableField(value = "media_name")
    private String mediaName;
    /**
     * 附件阅读次数
     */
    @TableField(value = "read_number")
    private Integer readNumber;
    /**
     * 状态 0删除 1正常
     */
    @TableField(value = "state")
    private Integer state;
    /**
     * 是否使用 0 否 1是
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 无效开始时间
     */
    @TableField(value = "start_time")
    private String startTime;
    /**
     * 无效结束时间
     */
    @TableField(value = "end_time")
    private String endTime;
    /**
     * 试题资料来源
     */
    @TableField(value = "question_origin")
    private String questionOrigin;
    /**
     * 出题人
     */
    @TableField(value = "create_man")
    private String createMan;
    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private String createtime;
    /**
     * 录入人ID
     */
    @TableField(value = "register")
    private String register;
    /**
     * 录入人机构ID
     */
    @TableField(value = "office_id")
    private String officeId;
    /**
     * 批次信息
     */
    @TableField(value = "batch")
    private String batch;
    /**
     * 最后修改时间
     */
    @TableField(value = "last_update_time")
    private String lastUpdateTime;
    /**
     * 最后修改用户ID
     */
    @TableField(value = "last_sys_user_id")
    private String lastSysUserId;
    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
    /**
     * 试题内容缩写
     */
    @TableField(value = "content_short")
    private String contentShort;
    /**
     * 使用次数
     */
    @TableField(value = "use_count")
    private Integer useCount;
    /***
     * 最后使用时间
     */
    @TableField(value = "last_use_time")
    private String lastUseTime;
    /**
     * 倒数第二次使用时间
     */
    @TableField(value = "last_use_bk")
    private String lastUseBk;
    /**
     * 上次使用试卷ID
     */
    @TableField(value = "last_paper")
    private String lastPaper;
    /**
     * 倒数第二次使用试卷ID
     */
    @TableField(value = "last_paper_bk")
    private String lastPaperBk;
    /**
     * 操作说明
     */
    @TableField(value = "operate_explain")
    private String operateExplain;
    /**
     * 归档时间
     */
    @TableField(value = "pigeonhole_time")
    private String pigeonholeTime;

    public String getId() {
        return id;
    }

    public QzTestQuestions setId(String id) {
        this.id = id;
        return this;
    }

    public String getBankId() {
        return bankId;
    }

    public QzTestQuestions setBankId(String bankId) {
        this.bankId = bankId;
        return this;
    }

    public Integer getQuestionClass() {
        return questionClass;
    }

    public QzTestQuestions setQuestionClass(Integer questionClass) {
        this.questionClass = questionClass;
        return this;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public QzTestQuestions setQuestionType(Integer questionType) {
        this.questionType = questionType;
        return this;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public QzTestQuestions setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public String getDifferent() {
        return different;
    }

    public QzTestQuestions setDifferent(String different) {
        this.different = different;
        return this;
    }

    public String getCognize() {
        return cognize;
    }

    public QzTestQuestions setCognize(String cognize) {
        this.cognize = cognize;
        return this;
    }

    public String getKnowlcodeId() {
        return knowlcodeId;
    }

    public QzTestQuestions setKnowlcodeId(String knowlcodeId) {
        this.knowlcodeId = knowlcodeId;
        return this;
    }

    public Integer getAnswertime() {
        return answertime;
    }

    public QzTestQuestions setAnswertime(Integer answertime) {
        this.answertime = answertime;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public QzTestQuestions setScore(Double score) {
        this.score = score;
        return this;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public QzTestQuestions setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
        return this;
    }

    public Integer getQnumber() {
        return qnumber;
    }

    public QzTestQuestions setQnumber(Integer qnumber) {
        this.qnumber = qnumber;
        return this;
    }

    public Integer getIsRandom() {
        return isRandom;
    }

    public QzTestQuestions setIsRandom(Integer isRandom) {
        this.isRandom = isRandom;
        return this;
    }

    public Integer getAnswerQnumber() {
        return answerQnumber;
    }

    public QzTestQuestions setAnswerQnumber(Integer answerQnumber) {
        this.answerQnumber = answerQnumber;
        return this;
    }

    public String getObjAnswer() {
        return objAnswer;
    }

    public QzTestQuestions setObjAnswer(String objAnswer) {
        this.objAnswer = objAnswer;
        return this;
    }

    public String getQuestionSolution() {
        return questionSolution;
    }

    public QzTestQuestions setQuestionSolution(String questionSolution) {
        this.questionSolution = questionSolution;
        return this;
    }

    public Integer getIsHaveChild() {
        return isHaveChild;
    }

    public QzTestQuestions setIsHaveChild(Integer isHaveChild) {
        this.isHaveChild = isHaveChild;
        return this;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public QzTestQuestions setChildCount(Integer childCount) {
        this.childCount = childCount;
        return this;
    }

    public String getMediaName() {
        return mediaName;
    }

    public QzTestQuestions setMediaName(String mediaName) {
        this.mediaName = mediaName;
        return this;
    }

    public Integer getReadNumber() {
        return readNumber;
    }

    public QzTestQuestions setReadNumber(Integer readNumber) {
        this.readNumber = readNumber;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public QzTestQuestions setState(Integer state) {
        this.state = state;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public QzTestQuestions setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public QzTestQuestions setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public QzTestQuestions setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getQuestionOrigin() {
        return questionOrigin;
    }

    public QzTestQuestions setQuestionOrigin(String questionOrigin) {
        this.questionOrigin = questionOrigin;
        return this;
    }

    public String getCreateMan() {
        return createMan;
    }

    public QzTestQuestions setCreateMan(String createMan) {
        this.createMan = createMan;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public QzTestQuestions setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public String getRegister() {
        return register;
    }

    public QzTestQuestions setRegister(String register) {
        this.register = register;
        return this;
    }

    public String getOfficeId() {
        return officeId;
    }

    public QzTestQuestions setOfficeId(String officeId) {
        this.officeId = officeId;
        return this;
    }

    public String getBatch() {
        return batch;
    }

    public QzTestQuestions setBatch(String batch) {
        this.batch = batch;
        return this;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public QzTestQuestions setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public String getLastSysUserId() {
        return lastSysUserId;
    }

    public QzTestQuestions setLastSysUserId(String lastSysUserId) {
        this.lastSysUserId = lastSysUserId;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public QzTestQuestions setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getContentShort() {
        return contentShort;
    }

    public QzTestQuestions setContentShort(String contentShort) {
        this.contentShort = contentShort;
        return this;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public QzTestQuestions setUseCount(Integer useCount) {
        this.useCount = useCount;
        return this;
    }

    public String getLastUseTime() {
        return lastUseTime;
    }

    public QzTestQuestions setLastUseTime(String lastUseTime) {
        this.lastUseTime = lastUseTime;
        return this;
    }

    public String getLastUseBk() {
        return lastUseBk;
    }

    public QzTestQuestions setLastUseBk(String lastUseBk) {
        this.lastUseBk = lastUseBk;
        return this;
    }

    public String getLastPaper() {
        return lastPaper;
    }

    public QzTestQuestions setLastPaper(String lastPaper) {
        this.lastPaper = lastPaper;
        return this;
    }

    public String getLastPaperBk() {
        return lastPaperBk;
    }

    public QzTestQuestions setLastPaperBk(String lastPaperBk) {
        this.lastPaperBk = lastPaperBk;
        return this;
    }

    public String getOperateExplain() {
        return operateExplain;
    }

    public QzTestQuestions setOperateExplain(String operateExplain) {
        this.operateExplain = operateExplain;
        return this;
    }

    public String getPigeonholeTime() {
        return pigeonholeTime;
    }

    public QzTestQuestions setPigeonholeTime(String pigeonholeTime) {
        this.pigeonholeTime = pigeonholeTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzTestQuestions{" +
                "id='" + id + '\'' +
                ", bankId='" + bankId + '\'' +
                ", questionClass=" + questionClass +
                ", questionType=" + questionType +
                ", difficulty='" + difficulty + '\'' +
                ", different='" + different + '\'' +
                ", cognize='" + cognize + '\'' +
                ", knowlcodeId='" + knowlcodeId + '\'' +
                ", answertime=" + answertime +
                ", score=" + score +
                ", questionTitle='" + questionTitle + '\'' +
                ", qnumber=" + qnumber +
                ", isRandom=" + isRandom +
                ", answerQnumber=" + answerQnumber +
                ", objAnswer='" + objAnswer + '\'' +
                ", questionSolution='" + questionSolution + '\'' +
                ", isHaveChild=" + isHaveChild +
                ", childCount=" + childCount +
                ", mediaName='" + mediaName + '\'' +
                ", readNumber=" + readNumber +
                ", state=" + state +
                ", status=" + status +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", questionOrigin='" + questionOrigin + '\'' +
                ", createMan='" + createMan + '\'' +
                ", createtime='" + createtime + '\'' +
                ", register='" + register + '\'' +
                ", officeId='" + officeId + '\'' +
                ", batch='" + batch + '\'' +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", lastSysUserId='" + lastSysUserId + '\'' +
                ", remark='" + remark + '\'' +
                ", contentShort='" + contentShort + '\'' +
                ", useCount=" + useCount +
                ", lastUseTime='" + lastUseTime + '\'' +
                ", lastUseBk='" + lastUseBk + '\'' +
                ", lastPaper='" + lastPaper + '\'' +
                ", lastPaperBk='" + lastPaperBk + '\'' +
                ", operateExplain='" + operateExplain + '\'' +
                ", pigeonholeTime='" + pigeonholeTime + '\'' +
                '}';
    }
}
