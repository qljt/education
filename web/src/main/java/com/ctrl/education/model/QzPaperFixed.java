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
 * 固定卷试卷题目表
 *
 * @author liyang
 * @name QzPaperFixed
 * @description
 * @date 2018-08-13 10:38
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_paper_fixed")
public class QzPaperFixed extends Model<QzPaperFixed> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 试题ID
     */
    @TableField(value = "question_id")
    @NotNull(message = "试题ID不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 32, message = "试题ID长度为1-32。", groups = {AddGroup.class, UpdateGroup.class})
    private String questionId;
    /**
     * 段落内容
     */
    @TableField(value = "paragraph_content")
    private String paragraphContent;
    /**
     * 区块ID
     */
    @TableField(value = "part_id")
    @NotNull(message = "区块ID不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 32, message = "区块ID长度为1-32。", groups = {AddGroup.class, UpdateGroup.class})
    private String partId;
    /**
     * 排列顺序
     */
    @TableField(value = "sort")
    private Integer sort;
    /**
     * 分数
     */
    @TableField(value = "score")
    private Double score;
    /**
     * 答错扣分值
     */
    @TableField(value = "deduct")
    private Double deduct;

    public String getId() {
        return id;
    }

    public QzPaperFixed setId(String id) {
        this.id = id;
        return this;
    }

    public String getQuestionId() {
        return questionId;
    }

    public QzPaperFixed setQuestionId(String questionId) {
        this.questionId = questionId;
        return this;
    }

    public String getParagraphContent() {
        return paragraphContent;
    }

    public QzPaperFixed setParagraphContent(String paragraphContent) {
        this.paragraphContent = paragraphContent;
        return this;
    }

    public String getPartId() {
        return partId;
    }

    public QzPaperFixed setPartId(String partId) {
        this.partId = partId;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public QzPaperFixed setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public QzPaperFixed setScore(Double score) {
        this.score = score;
        return this;
    }

    public Double getDeduct() {
        return deduct;
    }

    public QzPaperFixed setDeduct(Double deduct) {
        this.deduct = deduct;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzPaperFixed{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", paragraphContent='" + paragraphContent + '\'' +
                ", partId='" + partId + '\'' +
                ", sort=" + sort +
                ", score=" + score +
                ", deduct=" + deduct +
                '}';
    }
}
