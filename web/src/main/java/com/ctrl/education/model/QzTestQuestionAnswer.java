package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * com.ctrl.education.model
 * 客观题答案表
 *
 * @author liyang
 * @name QzTestQuestionAnswer
 * @description
 * @date 2018-08-15 14:03
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
public class QzTestQuestionAnswer extends Model<QzTestQuestionAnswer> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 试题ID
     */
    @TableField(value = "question_id")
    private String questionId;
    /**
     * 子题目ID
     */
    @TableField(value = "child_question_id")
    private String childQuestionId;
    /**
     * 选项内容
     */
    @TableField(value = "option_content")
    private String optionContent;
    /**
     * 选项名称
     */
    @TableField(value = "option_name")
    private String optionName;
    /**
     * 是否正确答案 0否 1是
     */
    @TableField(value = "is_correct")
    private Integer isCorrect;

    public String getId() {
        return id;
    }

    public QzTestQuestionAnswer setId(String id) {
        this.id = id;
        return this;
    }

    public String getQuestionId() {
        return questionId;
    }

    public QzTestQuestionAnswer setQuestionId(String questionId) {
        this.questionId = questionId;
        return this;
    }

    public String getChildQuestionId() {
        return childQuestionId;
    }

    public QzTestQuestionAnswer setChildQuestionId(String childQuestionId) {
        this.childQuestionId = childQuestionId;
        return this;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public QzTestQuestionAnswer setOptionContent(String optionContent) {
        this.optionContent = optionContent;
        return this;
    }

    public String getOptionName() {
        return optionName;
    }

    public QzTestQuestionAnswer setOptionName(String optionName) {
        this.optionName = optionName;
        return this;
    }

    public Integer getIsCorrect() {
        return isCorrect;
    }

    public QzTestQuestionAnswer setIsCorrect(Integer isCorrect) {
        this.isCorrect = isCorrect;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzTestQuestionAnswer{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", childQuestionId='" + childQuestionId + '\'' +
                ", optionContent='" + optionContent + '\'' +
                ", optionName='" + optionName + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
