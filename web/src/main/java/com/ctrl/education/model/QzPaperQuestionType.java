package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * com.ctrl.education.model
 * 试卷题型
 *
 * @author liyang
 * @name QzPaperQuestionType
 * @description
 * @date 2018-08-13 11:00
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_paper_question_type")
public class QzPaperQuestionType extends Model<QzPaperQuestionType> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 试卷ID
     */
    @TableField(value = "paper_id")
    @NotNull(message = "试卷ID不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 32, message = "试卷ID长度为1-32。", groups = {AddGroup.class, UpdateGroup.class})
    private String paperId;
    /**
     * 区块ID
     */
    @TableField(value = "part_id")
    @NotNull(message = "区块ID不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 32, message = "区块ID长度为1-32。", groups = {AddGroup.class, UpdateGroup.class})
    private String partId;
    /**
     * 题目数量
     */
    @TableField(value = "question_count")
    private Integer questionCount;
    /**
     * 题型 1 单项选择题2 多项选择题3 是非题4 简答题5 问答题6 填空题7 综合题
     */
    @TableField(value = "question_type")
    private Integer questionType;
    /**
     * 题型描述
     */
    @TableField(value = "alias")
    private String alias;
    /**
     * 顺序
     */
    @TableField(value = "sort")
    private Integer sort;
    /**
     * 答错扣分值
     */
    @TableField(value = "deduct")
    private Double deduct;
    /**
     * 每题的分数
     */
    @TableField(value = "score")
    private Double score;
    /**
     * 总分
     */
    @TableField(value = "sum_score")
    private Double sumScore;
    /**
     * 是否有例题 0否 1是
     */
    @TableField(value = "is_have_example")
    private Integer isHaveExample;
    /**
     * 例题ID
     */
    @TableField(value = "example_id")
    private String exampleId;
    /**
     * 大题目解释
     */
    @TableField(value = "explains")
    private String explains;

    public String getId() {
        return id;
    }

    public QzPaperQuestionType setId(String id) {
        this.id = id;
        return this;
    }

    public String getPaperId() {
        return paperId;
    }

    public QzPaperQuestionType setPaperId(String paperId) {
        this.paperId = paperId;
        return this;
    }

    public String getPartId() {
        return partId;
    }

    public QzPaperQuestionType setPartId(String partId) {
        this.partId = partId;
        return this;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public QzPaperQuestionType setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
        return this;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public QzPaperQuestionType setQuestionType(Integer questionType) {
        this.questionType = questionType;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public QzPaperQuestionType setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public QzPaperQuestionType setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Double getDeduct() {
        return deduct;
    }

    public QzPaperQuestionType setDeduct(Double deduct) {
        this.deduct = deduct;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public QzPaperQuestionType setScore(Double score) {
        this.score = score;
        return this;
    }

    public Double getSumScore() {
        return sumScore;
    }

    public QzPaperQuestionType setSumScore(Double sumScore) {
        this.sumScore = sumScore;
        return this;
    }

    public Integer getIsHaveExample() {
        return isHaveExample;
    }

    public QzPaperQuestionType setIsHaveExample(Integer isHaveExample) {
        this.isHaveExample = isHaveExample;
        return this;
    }

    public String getExampleId() {
        return exampleId;
    }

    public QzPaperQuestionType setExampleId(String exampleId) {
        this.exampleId = exampleId;
        return this;
    }

    public String getExplains() {
        return explains;
    }

    public QzPaperQuestionType setExplains(String explains) {
        this.explains = explains;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzPaperQuestionType{" +
                "id='" + id + '\'' +
                ", paperId='" + paperId + '\'' +
                ", partId='" + partId + '\'' +
                ", questionCount=" + questionCount +
                ", questionType=" + questionType +
                ", alias='" + alias + '\'' +
                ", sort=" + sort +
                ", deduct=" + deduct +
                ", score=" + score +
                ", sumScore=" + sumScore +
                ", isHaveExample=" + isHaveExample +
                ", exampleId='" + exampleId + '\'' +
                ", explains='" + explains + '\'' +
                '}';
    }
}
