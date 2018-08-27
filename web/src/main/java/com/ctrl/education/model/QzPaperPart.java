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
 * 试题区块表
 *
 * @author liyang
 * @name QzPaperPart
 * @description
 * @date 2018-08-11 14:43
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_paper_part")
public class QzPaperPart extends Model<QzPaperPart> {
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
     * 题库ID
     */
    @TableField(value = "bank_id")
    private String bankId;
    /**
     * 区块名称
     */
    @TableField(value = "part_name")
    @NotNull(message = "区块名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 100, message = "区块名称长度为1-100。", groups = {AddGroup.class, UpdateGroup.class})
    private String partName;
    /**
     * 区块说明
     */
    @TableField(value = "explains")
    private String explains;
    /**
     * 大题目设置选项
     */
    @TableField(value = "flag")
    private String flag;
    /**
     * 顺序
     */
    @TableField(value = "sort")
    private Integer sort;
    /**
     * 题目数量
     */
    @TableField(value = "question_count")
    private Integer questionCount;
    /**
     * 总分
     */
    @TableField(value = "sum_score")
    private Double sumScore;

    public String getId() {
        return id;
    }

    public QzPaperPart setId(String id) {
        this.id = id;
        return this;
    }

    public String getPaperId() {
        return paperId;
    }

    public QzPaperPart setPaperId(String paperId) {
        this.paperId = paperId;
        return this;
    }

    public String getBankId() {
        return bankId;
    }

    public QzPaperPart setBankId(String bankId) {
        this.bankId = bankId;
        return this;
    }

    public String getPartName() {
        return partName;
    }

    public QzPaperPart setPartName(String partName) {
        this.partName = partName;
        return this;
    }

    public String getExplains() {
        return explains;
    }

    public QzPaperPart setExplains(String explains) {
        this.explains = explains;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public QzPaperPart setFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public QzPaperPart setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public QzPaperPart setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
        return this;
    }

    public Double getSumScore() {
        return sumScore;
    }

    public QzPaperPart setSumScore(Double sumScore) {
        this.sumScore = sumScore;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzPaperPart{" +
                "id='" + id + '\'' +
                ", paperId='" + paperId + '\'' +
                ", bankId='" + bankId + '\'' +
                ", partName='" + partName + '\'' +
                ", explains='" + explains + '\'' +
                ", flag='" + flag + '\'' +
                ", sort=" + sort +
                ", questionCount=" + questionCount +
                ", sumScore=" + sumScore +
                '}';
    }
}
