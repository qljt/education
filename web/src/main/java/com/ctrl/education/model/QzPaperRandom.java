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
 * 随机卷抽题规则
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
@TableName("qz_paper_random")
public class QzPaperRandom extends Model<QzPaperRandom> {

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
     * 随机类型 0，全部随机；1指定知识点；2指定难易度；3指定知识点和难易度
     */
    @TableField(value = "random_type")
    private String randomType;
    /**
     * 知识点ID
     */
    @TableField(value = "knowlcode_id")
    private Integer knowlcodeId;
    /**
     * 指定知识点的题目数量
     */
    @TableField(value = "knowlcode_num")
    private Double knowlcodeNum;
    /**
     * 难易度(字典表)
     */
    @TableField(value = "difficulty")
    private Double difficulty;
    /**
     * 指定难易度题目数量
     */
    @TableField(value = "difficulty_num")
    private Double difficultyNum;
    /**
     * 题型名称
     */
    @TableField(value = "question_type_name")
    private Integer questionTypeName;
    /**
     * 知识点名称
     */
    @TableField(value = "knowlcode_name")
    private String knowlcodeName;

    public String getId() {
        return id;
    }

    public QzPaperRandom setId(String id) {
        this.id = id;
        return this;
    }

    public String getPaperId() {
        return paperId;
    }

    public QzPaperRandom setPaperId(String paperId) {
        this.paperId = paperId;
        return this;
    }

    public String getPartId() {
        return partId;
    }

    public QzPaperRandom setPartId(String partId) {
        this.partId = partId;
        return this;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public QzPaperRandom setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
        return this;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public QzPaperRandom setQuestionType(Integer questionType) {
        this.questionType = questionType;
        return this;
    }

    public String getRandomType() {
        return randomType;
    }

    public QzPaperRandom setRandomType(String randomType) {
        this.randomType = randomType;
        return this;
    }

    public Integer getKnowlcodeId() {
        return knowlcodeId;
    }

    public QzPaperRandom setKnowlcodeId(Integer knowlcodeId) {
        this.knowlcodeId = knowlcodeId;
        return this;
    }

    public Double getKnowlcodeNum() {
        return knowlcodeNum;
    }

    public QzPaperRandom setKnowlcodeNum(Double knowlcodeNum) {
        this.knowlcodeNum = knowlcodeNum;
        return this;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public QzPaperRandom setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public Double getDifficultyNum() {
        return difficultyNum;
    }

    public QzPaperRandom setDifficultyNum(Double difficultyNum) {
        this.difficultyNum = difficultyNum;
        return this;
    }

    public Integer getQuestionTypeName() {
        return questionTypeName;
    }

    public QzPaperRandom setQuestionTypeName(Integer questionTypeName) {
        this.questionTypeName = questionTypeName;
        return this;
    }

    public String getKnowlcodeName() {
        return knowlcodeName;
    }

    public QzPaperRandom setKnowlcodeName(String knowlcodeName) {
        this.knowlcodeName = knowlcodeName;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzPaperRandom{" +
                "id='" + id + '\'' +
                ", paperId='" + paperId + '\'' +
                ", partId='" + partId + '\'' +
                ", questionCount=" + questionCount +
                ", questionType=" + questionType +
                ", randomType='" + randomType + '\'' +
                ", knowlcodeId=" + knowlcodeId +
                ", knowlcodeNum=" + knowlcodeNum +
                ", difficulty=" + difficulty +
                ", difficultyNum=" + difficultyNum +
                ", questionTypeName=" + questionTypeName +
                ", knowlcodeName='" + knowlcodeName + '\'' +
                '}';
    }
}
